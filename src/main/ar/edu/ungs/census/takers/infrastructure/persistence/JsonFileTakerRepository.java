package ar.edu.ungs.census.takers.infrastructure.persistence;

import ar.edu.ungs.census.shared.domain.Service;
import ar.edu.ungs.census.shared.infrastructure.persistence.JsonFileRepository;
import ar.edu.ungs.census.takers.domain.Taker;
import ar.edu.ungs.census.takers.domain.TakerRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class JsonFileTakerRepository extends JsonFileRepository<Taker> implements TakerRepository {
	public JsonFileTakerRepository(ObjectMapper objectMapper) {
		super(objectMapper, "src/main/resources/takers.json");
	}

	@Override
	public void saveAll(List<Taker> takers) {
		try {
			this.persist(takers);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	@Override
	public Optional<Taker> findById(Long id) {
		try {
			List<Taker> aggregates = this.searchAll();

			return aggregates.stream().filter(x -> x.id().equals(id)).findFirst();
		} catch (Exception error) {
			return Optional.empty();
		}
	}

	@Override
	public List<Taker> searchAll() {
		try {
			return StreamSupport.stream(
					                    Spliterators.spliteratorUnknownSize(super.read().iterator(),
					                                                        Spliterator.ORDERED), false)
			                    .map(this::parseFromJson)
			                    .collect(Collectors.toList());
		} catch (Exception error) {
			return Collections.emptyList();
		}
	}

	@Override
	protected Map<String, Object> parseToJson(Taker aggregate) {
		return new HashMap<>() {{
			put("id", aggregate.id());
			put("name", aggregate.name());
		}};
	}

	@Override
	protected Taker parseFromJson(JsonNode aggregate) {
		return new Taker(aggregate.get("id").asLong(), aggregate.get("name").asText());
	}
}
