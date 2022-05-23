package ar.edu.ungs.app.web.controllers.blocks.create;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public final class CreateBlocksPostWebController {
	@PostMapping("/blocks")
	public String index(Model model) {
		return "redirect:takers/create";
	}
}
