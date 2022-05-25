package ar.edu.ungs.app.web.controllers.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class HomeGetWebController {
	@GetMapping("/")
	public String index() {
		return "/home/index";
	}
}
