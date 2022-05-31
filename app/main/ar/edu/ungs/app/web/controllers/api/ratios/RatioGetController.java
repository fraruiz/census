package ar.edu.ungs.app.web.controllers.api.ratios;

import ar.edu.ungs.census.blocks.application.BlockResponse;
import ar.edu.ungs.census.ratios.application.find.RatioFinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public final class RatioGetController {
	private final RatioFinder finder;

	public RatioGetController(RatioFinder finder) {
		this.finder = finder;
	}

	@GetMapping("/api/ratios")
	public List<Map<String, Object>> index() {
		return finder.find().blocks().stream().map(this::convertToJson).collect(Collectors.toList());
	}

	private Map<String, Object> convertToJson(BlockResponse blockResponse) {
		return new HashMap<>() {{
			put("latitude", blockResponse.coordinates().latitude());
			put("longitude", blockResponse.coordinates().longitude());

			if (blockResponse.taker().isPresent()) {
				put("taker_id", blockResponse.taker().get().id());
				put("taker_name", blockResponse.taker().get().name());
			}
		}};
	}
}
