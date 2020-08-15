package depaul.edu.FreightBid.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Bid implements Serializable{

	private static final long serialVersionUID = 3L;
	
	
	@Id
	private long id;
	
	
	private int rate;
	
	private Carrier carrier;
	
	@ManyToOne(cascade= CascadeType.ALL)
	private Lane lane;

}
