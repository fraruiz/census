package ar.edu.ungs.app.web.controllers.takers.create;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public final class CreateTakersPostWebController {
	@PostMapping("/takers")
	public String index(Model model) {
		return "redirect:ratios";
	}
}
