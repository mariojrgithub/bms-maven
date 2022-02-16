package service;

import java.util.List;

import exception.BooksNotFoundException;
import exception.SystemException;
import model.BookModel;

public interface BookService {
	
	// read all
	List<BookModel> fetchAllBooks() throws SystemException, BooksNotFoundException;
	
	// create
	BookModel addBook(BookModel bookModel) throws SystemException;
	
	// update
	BookModel updateBookCost(BookModel bookModel) throws SystemException;
	
	// delete
	BookModel deleteBook(int bookId) throws SystemException;

	// fetch a specific book
	BookModel fetchOneBook(int bookId) throws SystemException;	
	
	// exit
	void exitApplication() throws SystemException;

}
