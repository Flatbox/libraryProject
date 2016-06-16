package ch.hevs.bankservice;


import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;

@Stateless
public class LibraryBean implements Library {

	@PersistenceContext(name="libraryPU")
	private EntityManager em;
	
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
		
		Query query = em.createQuery("SELECT b FROM Book b, IN(b.categories) c WHERE c.id=:id");
		query.setParameter("id", id);
		return (List<Book>) query.getResultList();
	}

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



	
	

}
