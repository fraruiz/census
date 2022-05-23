package ar.edu.ungs.app.web.controllers.ratios.create;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class CreateRatioGetWebController {
	@GetMapping("/ratios/create")
	public String index() {
		return "/ratios/create/index";
	}
}
