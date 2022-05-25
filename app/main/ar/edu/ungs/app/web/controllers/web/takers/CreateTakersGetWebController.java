package ar.edu.ungs.app.web.controllers.web.takers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class CreateTakersGetWebController {
	@GetMapping("/takers/create")
	public String index() {
		return "/takers/create/index";
	}
}
