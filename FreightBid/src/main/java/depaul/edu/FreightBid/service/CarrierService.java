package depaul.edu.FreightBid.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import depaul.edu.FreightBid.model.Carrier;
import depaul.edu.FreightBid.model.CarrierRepository;

@Service
public class CarrierService {
	
	@Autowired
	CarrierRepository carrierRepo;
	
	
	public List<Carrier> getCarriers() {
		List <Carrier> carriers = new ArrayList<>();
		carrierRepo.findAll().forEach(carriers::add);
		
		return carriers;
	}
	
	public Carrier addCarrier(Carrier carrier) {
		
		return carrierRepo.save(carrier);
	}
	
	
	public void deleteCarrier(Carrier carrier) {
		carrierRepo.delete(carrier);
	}
	
	public Carrier getCarrier(Long carrierID) {
		return carrierRepo.findById(carrierID).get();
	}

}
