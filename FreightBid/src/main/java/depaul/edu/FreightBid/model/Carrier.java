package depaul.edu.FreightBid.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "carriers")
public class Carrier implements Serializable{

	private static final long serialVersionUID = 2L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carrier_id")
	private Long id;
	
	private String name;
	
	private int MC;
	
	private int DOT;
	
	private String entityType;
	
	private String primaryFirstName;
	
	private String primaryLastName;
	
	private String primaryEmail;
	
	@OneToMany(cascade= CascadeType.ALL)
	private Collection<Bid> bids = new ArrayList<>();
	
	
}
