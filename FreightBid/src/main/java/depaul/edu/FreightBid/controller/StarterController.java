package depaul.edu.FreightBid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("sessionData")
public class StarterController {
	
	
	@GetMapping("/freightBid")
	public String welcome(Model model) {
		model.addAttribute("model", "model");
		return "Welcome";
	}
	

}
