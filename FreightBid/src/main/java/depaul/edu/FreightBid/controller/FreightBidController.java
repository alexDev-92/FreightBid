package depaul.edu.FreightBid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import depaul.edu.FreightBid.model.Bid;
import depaul.edu.FreightBid.model.Lane;
import depaul.edu.FreightBid.model.LaneRepository;
import depaul.edu.FreightBid.service.LaneService;

@Controller
@RequestMapping("/freightBid/lanes")
public class FreightBidController {
	
	@Autowired
	LaneRepository laneRepo;
	
	@Autowired
	LaneService laneService;
	
	
	@GetMapping
	public String getAllLanes(Model model) {
		model.addAttribute("Lanes", laneRepo.findAll());
		
		return "lanes/viewLanes";
		
		
	}
	
	@RequestMapping(params = "addLane")
	public String addLane(Model model) {
		model.addAttribute("newLane", new Lane());
		return "lanes/addLane";
		
	}
	
	@PostMapping
	public String saveLane(@ModelAttribute("newLane") Lane lane, BindingResult binding  ) {
		if(binding.hasErrors()) {
			return "lanes/addLane";
		}
		
		laneRepo.save(lane);
		
		return "redirect:/freightBid/lanes";
		
		
		
	}
	
	@GetMapping("freightBid/lanes/laneBids/{id}")
	public String getLaneBids(@PathVariable(value = "id")Long id, Model model) {
		Lane lane = laneService.getLane(id);
		if(lane != null) {
			List <Bid> bids = laneService.getLaneBids(lane);
			model.addAttribute("bids",bids);
			
			
		}
		
		return "/bids/viewBids";
		
	}
		
	

}
