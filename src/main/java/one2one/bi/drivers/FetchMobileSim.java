package one2one.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import one2one.bi.entities.Mobile;
import one2one.bi.entities.SimCard;

public class FetchMobileSim 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em = emf.createEntityManager();

		Mobile mobile = em.find(Mobile.class, 1);
		System.out.println(mobile);
		
		if(mobile != null)
		{
			SimCard sim = mobile.getSim();
			System.out.println(sim);
		}
		
	}
}
