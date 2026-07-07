package one2one.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import one2one.bi.entities.Mobile;
import one2one.bi.entities.SimCard;

public class InsertMobileSim 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Mobile mobile = new Mobile();
		mobile.setBrand("Vivo");
		mobile.setModel("Z1 Pro");
		mobile.setPrice(15_000);
		
		SimCard card = new SimCard();
		card.setBrand("Jio");
		card.setType("micro");
		
		//ont-to-one bidirectional mapping
		mobile.setSim(card);
		card.setMobile(mobile);
		
		et.begin();
		
			em.persist(mobile);
			em.persist(card);
		
		et.commit();
		
	}
}
