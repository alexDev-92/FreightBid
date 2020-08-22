package depaul.edu.FreightBid.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bids")
public class Bid implements Serializable{

	private static final long serialVersionUID = 3L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "bid_id")
	private long id;
	
	@Column (name = "rate")
	private int rate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carrier_id")
	private Carrier carrier;
	
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "lane_id")
	private Lane lane;

}
