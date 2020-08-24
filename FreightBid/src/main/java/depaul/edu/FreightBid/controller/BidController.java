package depaul.edu.FreightBid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import depaul.edu.FreightBid.model.Bid;
import depaul.edu.FreightBid.model.BidRepository;
import depaul.edu.FreightBid.model.Carrier;
import depaul.edu.FreightBid.model.CarrierRepository;

@Controller
@RequestMapping("freightBid/bids")
public class BidController {
	
	@Autowired
	CarrierRepository carrierRepo;
	
	@Autowired
	BidRepository bidRepo;
	
	@GetMapping
	public String viewBids(Model model) {
		model.addAttribute("bids",bidRepo.findAll());
		return "bids/viewBids";
		
	}
	
	@RequestMapping(params = "addBid")
	public String addBid(Model model) {
		
		List<Carrier> carriers = carrierRepo.findAll();
		model.addAttribute("carriers", carriers);
		
		model.addAttribute("bid", new Bid());
		return "bids/addBid";
	}
	
	
	@PostMapping
	public String createBid(@ModelAttribute("bid") Bid bid, BindingResult binding ) {
		if(binding.hasErrors()) {
			return "bids/addBid";
		}
		//TODO:issue creating bid
		bidRepo.save(bid);
		
		return "redirect:/freightBid/bids";
		
	}
	
	
	
	
	
	
	

}
