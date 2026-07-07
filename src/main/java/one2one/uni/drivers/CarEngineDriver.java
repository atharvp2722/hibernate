package one2one.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import one2one.uni.entities.Car;
import one2one.uni.entities.Engine;

public class CarEngineDriver 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine e = new Engine();
		e.setCc(800);
		e.setTorque(60);
		e.setType("Petrol");
		
		Car c = new Car();
		c.setBrand("BMW");
		c.setColor("Blue");
		c.setPrice(20_00_000);
		
		c.setEngine(e);			//establishing mapping //to map engine with car //estb reln bw car and engine
		
		et.begin();
			em.persist(e);
			em.persist(c);
		et.commit();
		
		
		//fetch the car object
		// c!=null c.getEngine()
	}
}
