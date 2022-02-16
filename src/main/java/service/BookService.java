package service;

import java.util.List;

import model.BookModel;

public interface BookService {
	
	// read all
	List<BookModel> fetchAllBooks();
	
	// create
	BookModel addBook(BookModel bookModel);
	
	// update
	BookModel updateBookCost(BookModel bookModel);
	
	// delete
	BookModel deleteBook(int bookId);

	// fetch a specific book
	BookModel fetchOneBook(int bookId);	

}
