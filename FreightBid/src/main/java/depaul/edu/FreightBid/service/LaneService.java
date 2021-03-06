package depaul.edu.FreightBid.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import depaul.edu.FreightBid.model.Bid;
import depaul.edu.FreightBid.model.Lane;
import depaul.edu.FreightBid.model.LaneRepository;


@Service
public class LaneService {
	
	@Autowired
	LaneRepository laneRepo;
	
	//get all lanes
	public List<Lane> getLanes() {
		
		List<Lane> lane = new ArrayList<Lane>();
		laneRepo.findAll().forEach(lane::add);
		
		return lane;
	}
	
	//add a lane
	public Lane addLane(Lane lane) {
		return laneRepo.save(lane);
		
	}
	
	//delete a lane
	public void deleteLane(Lane lane) {
		laneRepo.delete(lane);
	}
	
	public List <Bid> getLaneBids(Lane lane){
		List <Bid> bids = new ArrayList<>();
		
		laneRepo.findById(lane.getId()).get().getBids().forEach(bids::add);
		return bids;
	}
	
	
	public Lane getLane(Long id) {
		return laneRepo.findById(id).get();
	}
	
	

}
