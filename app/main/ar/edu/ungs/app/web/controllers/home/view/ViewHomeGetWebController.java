package ar.edu.ungs.app.web.controllers.home.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class ViewHomeGetWebController {
	@GetMapping("/")
	public String index() {
		return "/home/index";
	}
}
