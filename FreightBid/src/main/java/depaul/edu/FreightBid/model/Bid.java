package depaul.edu.FreightBid.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Bid implements Serializable{

	private static final long serialVersionUID = 3L;
	
	
	@Id
	private long id;
	
	
	private int rate;
	
	private Carrier carrier;
	
	private Lane lane;

}
