package ar.edu.ungs.app.web.controllers.ratios.create;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public final class CreateRatioPostWebController {
	@PostMapping("/ratios")
	public String index(Model model) {
		return "redirect:/ratios";
	}
}
