package depaul.edu.FreightBid.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Carrier implements Serializable{

	private static final long serialVersionUID = 2L;

	
	@Id
	private Long id;
	
	private String name;
	
	private int MC;
	
	private int DOT;
	
	private String entityType;
	
	private String primaryFirstName;
	
	private String primaryLastName;
	
	private String primaryEmail;
	
	@OneToMany
	private Lane lane;
	
	
}
