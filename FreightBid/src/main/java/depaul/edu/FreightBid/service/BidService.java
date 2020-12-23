package depaul.edu.FreightBid.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import depaul.edu.FreightBid.model.Bid;
import depaul.edu.FreightBid.model.BidRepository;
import depaul.edu.FreightBid.model.Carrier;
import depaul.edu.FreightBid.model.CarrierRepository;
import depaul.edu.FreightBid.model.Lane;
import depaul.edu.FreightBid.model.LaneRepository;

@Service 
public class BidService {
	
	@Autowired
	BidRepository bidRepo;
	
	@Autowired
	CarrierRepository carrierRepo;
	
	@Autowired
	LaneRepository laneRepo;
	
	
	public Bid createBid(Long carrierID, Long laneID, Bid bid) {
		Carrier carrier = carrierRepo.findById(carrierID).get();
		bid.setCarrier(carrier);
		Lane lane = laneRepo.findById(laneID).get();
		bid.setLane(lane);
		
		return bidRepo.save(bid);	
		
	}
	
	
	
	public List<Bid> getBids(){
		List<Bid> bid = new ArrayList<>();
		bidRepo.findAll().forEach(bid::add);
		
		return bid;	
		
	}
	
	public Bid getBid(Long bidId) {
		Bid id = bidRepo.findById(bidId).get();
		
		return id;
	
	}
	
	public void deleteBid (Bid bid) {
		bidRepo.delete(bid);
	}
	
	public Bid addBid (Bid bid) {
		
		
		
		Bid newBid = bidRepo.save(bid);
		
		return newBid;
	}
	
	public List<Bid> getBidByLane(Lane lane){
		List <Bid> bids = new ArrayList<Bid>();
		bidRepo.findByLane(lane).forEach(bids::add);
		
		return bids;
	}
	
}
