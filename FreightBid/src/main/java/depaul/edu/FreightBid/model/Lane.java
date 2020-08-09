package depaul.edu.FreightBid.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Lane implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	private String shippingCity;
	
	private String shippingState;
	
	private String receivingCity;
	
	private String receivingState;
	
	private String commodity;
	
	private int volume;
	
	private String equipment;
	
	//@OneToOne(cascade =CascadeType.ALL)
	private Carrier carrier;
	
	
}
