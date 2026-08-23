package id.my.jvm.hendisantika.bookstore.service;

import java.util.List;

import id.my.jvm.hendisantika.bookstore.model.Book;

public interface BookService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveBook(Book book);

	/*
	 * READ
	 */
	public List<Book> listBooks();
	public Book getBook(Long id);

	/*
	 * DELETE
	 */
	public void deleteBook(Long id);

}
