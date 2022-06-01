package ar.edu.ungs.app.web.controllers.api.ratios;

import ar.edu.ungs.census.ratios.application.find.RatioFinder;
import ar.edu.ungs.census.ratios.application.generate.RatioGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public final class RatioPostController {
	private final RatioGenerator generator;

	public RatioPostController(RatioGenerator generator) {
		this.generator = generator;
	}

	@PostMapping("/api/ratios")
	public ResponseEntity<String> index() {
		generator.generate();

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
