package one2manyBidirectional.drivers;

import java.util.Arrays;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import one2manyBidirectional.entities.Department;
import one2manyBidirectional.entities.Employee;

public class InsertEmpDept
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_many_to_one");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Department d1 = new Department();
		d1.setName("IT");
		
		Employee e1 = new Employee();
		e1.setName("Atharv");
		e1.setAge(22);
		e1.setSalary(27_00_000);
		
		Employee e2 = new Employee();
		e2.setName("Stark");
		e2.setAge(27);
		e2.setSalary(10_00_00_000);
		
		//many_to_one
		e1.setDepartment(d1);
		e2.setDepartment(d1);
		
		//one_to_many
		d1.setEmployees(Arrays.asList(e1, e2));
		
		et.begin();
		
			em.persist(d1);
			em.persist(e1);
			em.persist(e2);
		
		et.commit();
	}
}
