package depaul.edu.FreightBid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import depaul.edu.FreightBid.model.Bid;
import depaul.edu.FreightBid.model.BidRepository;

@Controller
@RequestMapping("freightBid/bids")
public class BidController {
	
	BidRepository bidRepo;
	
	@GetMapping
	public String viewBids(Model model) {
		model.addAttribute("bids",bidRepo.findAll());
		return "bids/viewBids";
		
	}
	
	@RequestMapping(params = "addBid")
	public String addBid(Model model) {
		
		model.addAttribute("bid", new Bid());
		return "bids/addBid";
	}
	
	
	@PostMapping
	public String createBid(@ModelAttribute("bid") Bid bid, BindingResult binding ) {
		if(binding.hasErrors()) {
			return "bids/addBid";
		}
		
		bidRepo.save(bid);
		
		return "redirect:/freightBid/bids";
		
	}
	
	
	
	
	
	
	

}
