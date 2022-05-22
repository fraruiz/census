package ar.edu.ungs.app.web.controllers.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class GetIndexWebController {
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("name", "pepe");
		return "index";
	}
}
