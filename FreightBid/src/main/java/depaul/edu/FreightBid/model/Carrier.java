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
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table (name = "carriers")
public class Carrier implements Serializable{

	private static final long serialVersionUID = 2L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carrier_id", nullable  = false)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column (name = "mc")
	private int MC;
	
	@Column (name = "dot")
	private int DOT;
	
	@Column (name  = "entity_type")
	private String entityType;
	
	@Column (name = "primary_first_name")
	private String primaryFirstName;
	
	@Column (name = "primary_last_name")
	private String primaryLastName;
	
	@Column (name = "primary_email")
	private String primaryEmail;
	
	@OneToMany(
			mappedBy = "carrier",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
	@ToString.Exclude
	private List <Bid> bids;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lane_id")
	private Lane lane;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carriers_bidding", nullable = false)
	@JsonIgnore
	private Bid carriersBidding;
	
}
