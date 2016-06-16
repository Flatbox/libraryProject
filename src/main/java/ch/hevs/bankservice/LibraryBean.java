package ch.hevs.bankservice;


import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

<<<<<<< HEAD
=======
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import ch.hevs.businessobject.AudioBook;
>>>>>>> origin/master
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Ebook;
import ch.hevs.businessobject.Writer;

@Stateless
public class LibraryBean implements Library {

	@PersistenceContext(name="libraryPU")
	private EntityManager em;
	private UserTransaction tx;
	
	@Resource
	private SessionContext ctx;
	
	//Category
	@Override
	public List<Category> getCategories() {
		List<Category> categoryList = (List<Category>) em.createQuery("SELECT ath FROM Category ath").getResultList();
		return categoryList;
	}
	
	@Override
	public String getCategoryName(Category c) {
		
		String catname = c.getName();
		
		return catname;
	}

	//Books
	@Override
	public List<Book> getBooksByCategory(long id) {
		
		Query query = em.createQuery("FROM Book b, IN(b.categories) c WHERE c.id=:id");
		query.setParameter("id", id);
		return (List<Book>) query.getResultList();
	}

<<<<<<< HEAD
		//Add Book
	
	@Override
	public void addBook(Book b, Category c) {
		
		//Programmic Security
		if (ctx.isCallerInRole("administrator")) {
			b.addCategory(c);
			
			em.merge(b);
		}
		
		
		
	}


	@Override
	public void deleteBook(long id) {
		//Programmic Security
		if (ctx.isCallerInRole("administrator")) {
			Query query = em.createQuery("SELECT b FROM Book b WHERE b.id =:id");
			query.setParameter("id", id);
			
			Book book = (Book)query.getSingleResult();
			
			em.remove(book);
			em.flush();
		}

	}



=======
	@Override
	public List<Writer> getWriters() {
		List<Writer> writerList = (List<Writer>) em.createQuery("FROM Writer w").getResultList();
		return writerList;
	}

	@Override
	public List<Book> getBooksByWriter(long id) {
		Query query = em.createQuery("SELECT b FROM Book b, IN(b.writers) w WHERE w.id=:id");
		query.setParameter("id", id);
		return (List<Book>) query.getResultList();
	}

	@Override
	public List<Book> booksList() {
		Query query = em.createQuery("FROM Book b");
		return (List<Book>) query.getResultList();
	}

	@Override
	public List<AudioBook> audiobooksList() {
		List<AudioBook> audiobooksList = (List<AudioBook>) em.createQuery("FROM AudioBook ab").getResultList();
		return audiobooksList;
	}

	@Override
	public List<Ebook> ebooksList() {
		List<Ebook> ebooksList = (List<Ebook>) em.createQuery("FROM Ebook e").getResultList();
		return ebooksList;
	}

	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public void updateTaken(AudioBook audiobook) {
		System.out.println(audiobook.getId());
		audiobook.setTaken(true);
		}
>>>>>>> origin/master
	
	

}
