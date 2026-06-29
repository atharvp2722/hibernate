package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	generator = "id_gen")
	@SequenceGenerator(			
			name = "id_gen",
			initialValue = 1000, //initial id/ first id
			allocationSize = 1) //by how much it will increase
	private long id;
	private String name;
	private double price;
}
