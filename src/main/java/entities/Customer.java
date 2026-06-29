package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//Entity Class

@Entity
@Table(name = "customers") //to give custom name to the table
						  //by default table name will be the class name
//@Getter				 //auto creates getters
//@Setter				//auto creates setters
@Data				   //auto creates getters and setter as well as overrides some methods like toString, Hashcode etc

public class Customer 
{
	//properties will act as Columns
	
	@Id		//add primary key constraints to int id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//will auto create serials (s.no)
	private int id;
	
	@Column(nullable = false)		//column cannot be null
	private String name;
	
	@Column(unique = true)			//column must have unique values
	private String email;
	
	private String address;
	
	@CreationTimestamp				//will auto take current time
	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDate updatedAt;
	
}