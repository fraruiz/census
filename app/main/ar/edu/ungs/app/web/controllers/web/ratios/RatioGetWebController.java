package ar.edu.ungs.app.web.controllers.web.ratios;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class RatioGetWebController {
	@GetMapping("/ratios")
	public String index(Model model) {
		return "/ratios/view/index";
	}
}
