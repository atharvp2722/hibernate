package drivers;

//To insert / fetch / update multiple records

import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Insert 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
			Customer c1 = new Customer();
			c1.setName("Atharv");
			c1.setEmail("atharvpawarhg194@gmail.com");
			c1.setAddress("Pune");
			
			Customer c2 = new Customer();
			c2.setName("Jerry");
			c2.setEmail("sd@gmail.com");
			c2.setAddress("Mumbai");
			
			Customer c3 = new Customer();
			c3.setName("Stark");
			c3.setEmail("ironman@gmail.com");
			c3.setAddress("New York");
		
			em.persist(c1);
			em.persist(c2);
			em.persist(c3);
			
		et.commit();

	}
}
