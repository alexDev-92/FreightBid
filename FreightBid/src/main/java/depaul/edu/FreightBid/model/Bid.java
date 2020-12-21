package depaul.edu.FreightBid.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "bids")
public class Bid implements Serializable{

	private static final long serialVersionUID = 3L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "bid_id", nullable = false)
	private long id;
	
	@Column (name = "rate")
	private int rate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carrier_id" )
	@JsonIgnore
	private Carrier carrier;
	
	
	@OneToMany(
			mappedBy = "carriersBidding",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
	@ToString.Exclude
	private List <Carrier> carrierList;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lane_id")
	@JsonIgnore
	private Lane lane;

}
