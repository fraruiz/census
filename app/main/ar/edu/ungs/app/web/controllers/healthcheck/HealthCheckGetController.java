package ar.edu.ungs.app.web.controllers.healthcheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public final class HealthCheckGetController {
	@GetMapping("/ping")
	public Map<String, Object> index(){
		return new HashMap<>(){{
			put("application", "census");
			put("command", "web");
			put("type", "server");
			put("status", "ok");
		}};
	}
}
