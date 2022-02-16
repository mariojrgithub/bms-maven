package service;

import java.util.List;

import dao.BookDao;
import dao.BookDaoImpl;
import dao.BookJDBCDaoImpl;
import exception.BooksNotFoundException;
import exception.SystemException;
import model.BookModel;

public class BookServiceImpl implements BookService {
	
	BookDao bookDao;
	
	public BookServiceImpl() {
		
//		bookDao = new BookDaoImpl(); 
		bookDao = new BookJDBCDaoImpl();

	}

	@Override
	public List<BookModel> fetchAllBooks() throws SystemException, BooksNotFoundException {

		return bookDao.fetchAllBooks();
	}

	@Override
	public BookModel addBook(BookModel bookModel) throws SystemException {

		return bookDao.addBook(bookModel);
	}

	@Override
	public BookModel updateBookCost(BookModel bookModel) throws SystemException {

		return bookDao.updateBookCost(bookModel);
	}

	@Override
	public BookModel deleteBook(int bookId) throws SystemException {

		return bookDao.deleteBook(bookId);
	}

	@Override
	public BookModel fetchOneBook(int bookId) throws SystemException {
		
		return bookDao.fetchOneBook(bookId);
	}

	@Override
	public void exitApplication() throws SystemException {
		
		bookDao.exitApplication();
		
	}

}
