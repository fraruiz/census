package ar.edu.ungs.app.web.controllers.api.takers;

import ar.edu.ungs.census.takers.application.create.TakerSaver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class TakersPostController {
	private final TakerSaver saver;

	public TakersPostController(TakerSaver saver) {
		this.saver = saver;
	}

	@PostMapping("/api/takers")
	public ResponseEntity<String> index(@RequestBody List<String> names) {
		saver.save(names);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
