package service;

import java.util.List;

import dao.BookDao;
import dao.BookDaoImpl;
import model.BookModel;

public class BookServiceImpl implements BookService {
	
	BookDao bookDao;
	
	public BookServiceImpl() {
		
		bookDao = new BookDaoImpl(); 

	}

	@Override
	public List<BookModel> fetchAllBooks() {

		return bookDao.fetchAllBooks();
	}

	@Override
	public BookModel addBook(BookModel bookModel) {

		return bookDao.addBook(bookModel);
	}

	@Override
	public BookModel updateBookCost(BookModel bookModel) {

		return bookDao.updateBookCost(bookModel);
	}

	@Override
	public BookModel deleteBook(int bookId) {

		return bookDao.deleteBook(bookId);
	}

	@Override
	public BookModel fetchOneBook(int bookId) {
		
		return bookDao.fetchOneBook(bookId);
	}

}
