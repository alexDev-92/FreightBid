package depaul.edu.FreightBid.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Lane implements Serializable{
	private static final long serialVersionUID = 1;
	
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
