package ch.hevs.bankservice;

import java.util.List;

import ch.hevs.businessobject.AudioBook;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Ebook;
import ch.hevs.businessobject.Writer;

public interface Library {
	
	//Books
	public Book getBook();
	
	public List<Book> booksList();
	
	//Categories
	public List<Category> getCategories();
	
	public List<Book> getBooksByCategory(long id);



	//Person
	
	public List<Writer> getWriters();

	public List<Book> getBooksByWriter(long id);

	public List<AudioBook> audiobooksList();

	public List<Ebook> ebooksList();
	
	
}
