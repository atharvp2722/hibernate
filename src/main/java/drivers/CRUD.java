package drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import entities.Customer;

public class CRUD 
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();
		
		//et is required only for DML operations
		EntityTransaction et = em.getTransaction();
		
		
		//1. Inserting a Record
		Customer c = new Customer();
		c.setName("Atharv");
		c.setAddress("Pune");
		c.setEmail("atharvpawarhg194@gmail.com");
		
		et.begin();
			//em.persist(c);		//insert record
		et.commit();
		
		
		//2. Fetching a record
		Customer customer = em.find(Customer.class, 1);
		System.out.println(customer); 					//can use obj ref var dir since toString() id overridden 
													   //with help of @Data annotation
		
		//3. Update the record (first fetch then update)
		et.begin();
		
			//Fetch the record to be updated
			Customer c2 = em.find(Customer.class, 1);
			
			//update only when there is some value(i.e it is not null)
			//since we might get nullpointerexception if we try to update the null value 
			if(c2 != null)
			{
				c2.setEmail("2203113@ritindia.edu");
				c2.setName("Atharv Pawar");
			}
			
			
			//4. Remove a record (first fetch then delete/remove)
			Customer c3 = em.find(Customer.class, 1);
			
			em.remove(c3);
			
		et.commit();		
	}
}