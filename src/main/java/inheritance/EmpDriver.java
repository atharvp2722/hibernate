package inheritance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmpDriver 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		PartTimeEmployee p = new PartTimeEmployee();
		p.setName("Peter Parker");
		p.setAge(21);
		p.setHours(4);
		p.setMonths(6);
		p.setPay(10000);
		
		FullTimeEmployee f = new FullTimeEmployee();
		f.setName("Atharv");
		f.setAge(22);
		f.setExp(2);
		f.setSalary(2000000);
		
		et.begin();
			em.persist(p);
			em.persist(f);
		et.commit();
	}
}
