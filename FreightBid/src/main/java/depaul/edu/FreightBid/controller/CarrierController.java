package depaul.edu.FreightBid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import depaul.edu.FreightBid.model.Carrier;
import depaul.edu.FreightBid.model.CarrierRepository;
import depaul.edu.FreightBid.service.CarrierService;

@Controller
@RequestMapping("freightBid/Carriers")
public class CarrierController {
	
	@Autowired
	CarrierRepository carrierRepo;
	
	@Autowired
	CarrierService carrierService;
	
	@GetMapping
	public String getCarriers(Model model) {
		model.addAttribute("carriers", carrierRepo.findAll());
		
		return "carriers/viewCarriers";
	}
	
	@RequestMapping(params = "addCarrier")
	public String addCarrier(Model model) {
		model.addAttribute("newCarrier", new Carrier());
		
		return "carriers/addCarrier";
	}

	@PostMapping
	public String createCarrier(@ModelAttribute("newCarrier") Carrier carrier, BindingResult binding  ) {
		
		if(binding.hasErrors()) {
			return "carrier/addCarrier";
		}
		
		carrierRepo.save(carrier);
		
		return "redirect:/freightBid/Carriers";
		
	}
	

}
