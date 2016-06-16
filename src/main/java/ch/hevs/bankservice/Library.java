package ch.hevs.bankservice;

import java.util.List;

import ch.hevs.businessobject.AudioBook;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Ebook;
import ch.hevs.businessobject.Writer;

public interface Library {
	
	//Books
	
	public void addBook(Book b, Category c);
	
	public void deleteBook(long id);
	
	public List<Book> booksList();
	
	public void updateTaken(AudioBook audiobook);
	
	//Categories
	public List<Category> getCategories();
	
	public List<Book> getBooksByCategory(long id);
	
	public String getCategoryName(Category c);



	//Person
	
	public List<Writer> getWriters();

	public List<Book> getBooksByWriter(long id);

	public List<AudioBook> audiobooksList();

	public List<Ebook> ebooksList();
	
	
}
