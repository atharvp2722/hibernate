package many2many.bi.drivers;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import many2many.bi.entities.Developer;
import many2many.bi.entities.Language;

public class InsertDevLang 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("many_to_many");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Developer d1 = new Developer();
		d1.setName("Atharv");
		d1.setRole("Trainee");
		d1.setExp(1);
		
		Developer d2 = new Developer();
		d2.setName("Peter");
		d2.setRole("ASE");
		d2.setExp(3);
		
		Language l1 = new Language();
		l1.setName("Java");
		l1.setVersion("JDK 26");
		
		Language l2 = new Language();
		l2.setName("Python");
		l2.setVersion("Py 8");
		
		List<Developer> devs = Arrays.asList(d1, d2);
		
		List<Language> langs= Arrays.asList(l1, l2);
		
		d1.setLanguages(langs);
		d2.setLanguages(langs);
		//or we can traverse too i.e use for each
		
		l1.setDevelopers(devs);
		l2.setDevelopers(devs);
		
		et.begin();
		
			for(Developer d : devs)
			{
				em.persist(d);
			}
			
			//or we can use lambda expression too
			langs.forEach(l -> em.persist(l));
		
		et.commit();
	}
}
