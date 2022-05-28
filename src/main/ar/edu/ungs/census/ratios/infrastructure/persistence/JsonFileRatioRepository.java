package ar.edu.ungs.census.ratios.infrastructure.persistence;

import ar.edu.ungs.census.blocks.domain.Block;
import ar.edu.ungs.census.coordinates.domain.Coordinates;
import ar.edu.ungs.census.ratios.domain.Ratio;
import ar.edu.ungs.census.ratios.domain.RatioRepository;
import ar.edu.ungs.census.shared.domain.Service;
import ar.edu.ungs.census.shared.infrastructure.persistence.JsonFileRepository;
import ar.edu.ungs.census.takers.domain.Taker;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import org.springframework.boot.json.JsonParser;

import java.util.*;
import java.util.stream.Collectors;

@Service
public final class JsonFileRatioRepository extends JsonFileRepository<Ratio> implements RatioRepository {
	public JsonFileRatioRepository(ObjectMapper objectMapper) {
		super(objectMapper, "ratio.json");
	}

	@Override
	public void save(Ratio ratio) {
		try {
			persist(ratio);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	@Override
	public Optional<Ratio> find() {
		try {
			return Optional.of(parseFromJson(read()));
		} catch (Exception error) {
			return Optional.empty();
		}
	}

	private Map<String, Object> parseToJson(Block block) {
		return new HashMap<>() {{
			put("id", block.id());
			put("coordinates", new HashMap<String, Object>() {{
				put("latitude", block.coordinates().latitude());
				put("longitude", block.coordinates().longitude());
			}});
		}};
	}

	private Block parseBlockFromJson(JsonNode block) {
		JsonNode coordinatesJsonNode = block.get("coordinates");

		Coordinates coordinates = new Coordinates(coordinatesJsonNode.get("latitude").asDouble(),
		                                          coordinatesJsonNode.get("longitude").asDouble());

		return new Block(block.get("id").asLong(), coordinates);
	}

	@Override
	protected Map<String, Object> parseToJson(Ratio aggregate) {
		return new HashMap<>() {{
			put("values", aggregate.blocks().stream().map(block -> new HashMap<String, Object>() {{
				put("block", parseToJson(block));
				put("neighbours", aggregate.neighbours(block)
				                           .stream()
				                           .map(JsonFileRatioRepository.this::parseToJson)
				                           .collect(Collectors.toList()));
			}}).collect(Collectors.toList()));
			put("assignments", aggregate.blocks().stream().map(block -> new HashMap<String, Object>() {{
				put("block", parseToJson(block));

				Taker assigned = aggregate.assigned(block);

				if (assigned != null) {
					put("taker", new HashMap<String, Object>() {{
						put("id", assigned.id());
						put("name", assigned.name());
					}});
				} else {
					put("taker", null);
				}

			}}).collect(Collectors.toList()));
		}};
	}

	@Override
	protected Ratio parseFromJson(JsonNode aggregate) {
		Ratio ratio = new Ratio();

		JsonNode values = aggregate.get("values");
		values.forEach(value -> {
			Block block = parseBlockFromJson(value.get("block"));

			(value.get("neighbours")).forEach(neighbourMap -> {
				Block neighbour = parseBlockFromJson(neighbourMap);

				ratio.add(block, neighbour);
			});

		});

		JsonNode assignments = aggregate.get("assignments");

		assignments.forEach(assignment -> {
			if (!assignment.get("taker").equals(NullNode.getInstance())) {
				Block block = parseBlockFromJson(assignment.get("block"));
				Taker taker = new Taker(assignment.get("taker").get("id").asLong(),
				                        assignment.get("taker").get("name").asText());

				ratio.assign(taker, block);
			}
		});
		return ratio;
	}
}
