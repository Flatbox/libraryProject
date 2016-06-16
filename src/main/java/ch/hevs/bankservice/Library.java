package ch.hevs.bankservice;

import java.util.List;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;

public interface Library {
	
	//Books
	
	public void addBook(Book b, Category c);
	
	public void deleteBook(long id);
	
	//Categories
	public List<Category> getCategories();
	
	public List<Book> getBooksByCategory(long id);
	
	public String getCategoryName(Category c);

	//Person
	
	
}
