package depaul.edu.FreightBid.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BidRepository extends JpaRepository<Bid, Long>{
	

	List <Bid> findByLane(Lane lane);
}
