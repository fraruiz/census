package ar.edu.ungs.app.web.controllers.takers.create;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class CreateTakersGetWebController {
	@GetMapping("/takers/create")
	public String index() {
		return "/takers/create/index";
	}
}
