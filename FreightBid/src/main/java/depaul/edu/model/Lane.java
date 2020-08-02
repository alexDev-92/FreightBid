package depaul.edu.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Lane {
	
	@Id
	private long id;
	
	private String shippingCity;
	
	private String shippingState;
	
	private String receivingCity;
	
	private String receivingState;
	
	private String commodity;
	
	private int volume;
	
	private String equipment;
	
	
}
