package depaul.edu.FreightBid.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table (name = "lanes")
public class Lane implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lane_id")
	private long id;
	
	@Column(name = "shipping_city")
	private String shippingCity;
	
	@Column (name  = "shipping_state")
	private String shippingState;
	
	@Column (name  = "receiving_city")
	private String receivingCity;
	
	@Column (name = "receiving_state")
	private String receivingState;
	
	@Column (name = "commodity")
	private String commodity;
	
	@Column (name = "volume")
	private int volume;
	
	@Column (name = "equipment")
	private String equipment;
	
	@OneToMany(
			mappedBy = "lane",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
	@ToString.Exclude
	private List <Bid> bids;
	//private Bid bids;
	
	
	//@OneToOne
	//private Carrier carrier;
	
}
