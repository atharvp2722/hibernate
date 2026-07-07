package one2many.drivers;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import one2many.entities.Book;
import one2many.entities.Library;

public class InsertLibraryBooks
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_many");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Library library = new Library();
		library.setName("Library 1");
		library.setAddress("Wakad");
		
		Book book1 = new Book();
		book1.setTitle("Avengers Secret Wars");
		book1.setAuthor("Stan Lee");
		book1.setPrice(5000);
		
		Book book2 = new Book();
		book2.setTitle("Bhagvad Geeta");
		book2.setAuthor("Krishna Vasudev Yadav");
		book2.setPrice(300);
		
		Book book3 = new Book();
		book3.setTitle("The Amazing Spider Man");
		book3.setAuthor("Steve Ditko");
		book3.setPrice(2000);
		
		List<Book> books = Arrays.asList(book1, book2, book3);
		library.setBooks(books);
		
		
		Library library2 = new Library();
		library2.setName("Library 2");
		library2.setAddress("Mumbai");
		
		Book book4 = new Book();
		book4.setTitle("Java");
		book4.setAuthor("James Goslings");
		book4.setPrice(3000);
		
		Book book5 = new Book();
		book5.setTitle("JavaScript");
		book5.setAuthor("Brenden Each");
		book5.setPrice(4000);
		
		Book book6 = new Book();
		book6.setTitle("The Avengers");
		book6.setAuthor("Joe Russo");
		book6.setPrice(10000);
		
		List<Book> books2 = Arrays.asList(book4, book5, book6);
		
		library2.setBooks(books2);
		
		et.begin();
		
			for(Book b : books)
			{
				em.persist(b);
			}
			
			em.persist(library);
			
			
			for(Book b : books2)
			{
				em.persist(b);
			}
			
			em.persist(library2);
		
		et.commit();
	}
}
