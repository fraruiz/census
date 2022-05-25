package ar.edu.ungs.app.web.controllers.web.blocks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class BlocksGetWebController {
	@GetMapping("/blocks")
	public String index() {
		return "/blocks/create/index";
	}
}
