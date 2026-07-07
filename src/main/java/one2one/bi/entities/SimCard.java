package one2one.bi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity				//is mandatory
@Data				//not mandatory since we can give manual getters and setters
public class SimCard 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String type;
	private String brand;
	
	@OneToOne(mappedBy = "sim")
	private Mobile mobile;
}
