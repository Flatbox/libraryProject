package ch.hevs.bankservice;

import java.util.List;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;

public interface Library {
	
	//Books
	public Book getBook();
	
	//Categories
	public List<Category> getCategories();
	
	public List<Book> getBooksByCategory(long id);

	//Person
	
	
}
