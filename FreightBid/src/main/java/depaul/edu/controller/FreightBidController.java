package depaul.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import depaul.edu.model.Lane;
import depaul.edu.model.LaneRepository;

@Controller
@RequestMapping("/freightBid/lanes")
public class FreightBidController {
	
	LaneRepository laneRepo;
	
	
	@GetMapping
	public String getAllLanes(Model model) {
		model.addAttribute("newLane", laneRepo.findAll());
		
		return "lanes/allLanes";
		
		
	}
	
	
	
	
	

}
