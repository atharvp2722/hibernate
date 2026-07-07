package many2one.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import many2one.entities.Cart;
import many2one.entities.Product;

public class InsertCartProducts 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("many_to_one");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Product p1 = new  Product();
		p1.setName("Laptop");
		p1.setPrice(70_000);
		p1.setQuantity(100);
		
		Product p2 = new Product();
		p2.setName("PS5");
		p2.setPrice(70_000);
		p2.setQuantity(10);
		
		Cart cart = new Cart();
		cart.setType("Normal");
		
		p1.setCart(cart);
		p2.setCart(cart);
		
		et.begin();
		
			em.persist(cart);
			em.persist(p1);
			em.persist(p2);
		
		et.commit();
	}
}
