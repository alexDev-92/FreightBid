package depaul.edu.FreightBid.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import depaul.edu.FreightBid.model.Bid;
import depaul.edu.FreightBid.model.BidRepository;

@Service 
public class BidService {
	
	@Autowired
	BidRepository bidRepo;
	
	
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
	
}
