package one2one.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import one2one.uni.entities.Car;
import one2one.uni.entities.Engine;

public class FetchCarEngine 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em = emf.createEntityManager();
		
		Car car = em.find(Car.class, 1);
		System.out.println(car);
		
		if(car != null)
		{
			Engine engine = car.getEngine();
			System.out.println(engine);
		}
	}
}
