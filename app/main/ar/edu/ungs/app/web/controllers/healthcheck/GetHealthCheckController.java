package ar.edu.ungs.app.web.controllers.healthcheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class GetHealthCheckController {
	@GetMapping("/ping")
	public String index(){
		return "pong";
	}
}
