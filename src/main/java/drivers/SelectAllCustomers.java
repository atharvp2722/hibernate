package drivers;

import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class SelectAllCustomers 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();

		TypedQuery<Customer> query = em.createQuery("Select c from Customer c", Customer.class);
		
		java.util.List<Customer> list = query.getResultList();
		
		list.forEach(System.out :: println);
		
		
		//OR
		
		em.createQuery("from Customer c", Customer.class)
			.getResultList()
			.forEach(System.out :: println);
	}
}
