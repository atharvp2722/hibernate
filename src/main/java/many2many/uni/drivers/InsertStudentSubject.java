package many2many.uni.drivers;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import many2many.uni.entities.Student;
import many2many.uni.entities.Subject;

public class InsertStudentSubject 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("many_to_many");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student();
		s1.setName("Atharv");
		s1.setAge(22);
		s1.setSec('A');
		
		Student s2 = new Student();
		s2.setName("Stark");
		s2.setAge(27);
		s2.setSec('S');
		
		Subject sub1 = new Subject();
		sub1.setName("Java");
		sub1.setCredits(10);
		
		Subject sub2 = new Subject();
		sub2.setName("SQL");
		sub2.setCredits(7);
		
		List<Subject> subjects = Arrays.asList(sub1, sub2);
		
		s1.setSubjects(subjects);
		s2.setSubjects(subjects);
		
		et.begin();
		
			for(Subject s : subjects)
			{
				em.persist(s);
			}
			//or we can directly use em.persist(sub1)
			//em.persist(sub2)
			
			em.persist(s1);
			em.persist(s2);
		
		et.commit();
	}
}
