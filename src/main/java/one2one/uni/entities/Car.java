package one2one.uni.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Car 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String brand;
	private String color;
	private double price;
	
	/*
	 * FETCH TYPES : EAGER, LAZY
	 * 
	 * default for - one_to_one , many_to_one : EAGER
	 * default for - one_to_many , many_to_many : LAZY
	 */
	@OneToOne(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Engine engine;
}
