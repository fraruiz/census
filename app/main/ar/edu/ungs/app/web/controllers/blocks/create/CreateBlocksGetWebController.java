package ar.edu.ungs.app.web.controllers.blocks.create;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class CreateBlocksGetWebController {
	@GetMapping("/blocks/create")
	public String index() {
		return "/blocks/create/index";
	}
}
