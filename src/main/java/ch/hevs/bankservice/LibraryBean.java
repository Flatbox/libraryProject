package ch.hevs.bankservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import ch.hevs.businessobject.AudioBook;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Ebook;
import ch.hevs.businessobject.Writer;

@Stateless
public class LibraryBean implements Library {

	@PersistenceContext(name="libraryPU")
	private EntityManager em;
	private UserTransaction tx;
	
	
	// Fausse méthode sans utiliser la base de donnée
	@Override
	public Book getBook() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Date date = new Date();
		String ladate = "01/01/1999";
		
		try {
			date = dateFormat.parse(ladate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Book book = new Book("Istambul le début de l'asie ?" ,date  , "A11585A");
		return book;
	}

	// Temporaire
	
	@Override
	public List<Category> getCategories() {
		List<Category> categoryList = (List<Category>) em.createQuery("SELECT ath FROM Category ath").getResultList();
		return categoryList;
	}

	@Override
	public List<Book> getBooksByCategory(long id) {
		
		Query query = em.createQuery("FROM Book b, IN(b.categories) c WHERE c.id=:id");
		query.setParameter("id", id);
		return (List<Book>) query.getResultList();
	}

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
	
	

}
