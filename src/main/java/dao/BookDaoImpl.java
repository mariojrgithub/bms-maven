package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.BookModel;

public class BookDaoImpl implements BookDao {
	
	// collection of books
	List<BookModel> allBooks;
	

	public BookDaoImpl() {
		
		// create and add three BookModels
		allBooks = new ArrayList<BookModel>();
		
		allBooks.add(new BookModel(101, "Harry Potter and the Chamber of Secrets", "J.K. Rowlling", "Fiction", 40, ""));
		allBooks.add(new BookModel(102, "Harry Potter and the Goblet of Fire", "J.K. Rowlling", "Fiction", 35, ""));
		allBooks.add(new BookModel(103, "Harry Potter and the Half Blood Prince", "J.K. Rowlling", "Fiction", 44, ""));
	}

	@Override
	public List<BookModel> fetchAllBooks() {
		return allBooks;
	}

	@Override
	public BookModel addBook(BookModel bookModel) {
		// create new ID
		int newBookId = allBooks.get(allBooks.size() - 1).getBookId() + 1;
		
		// set new ID
		bookModel.setBookId(newBookId);
		
		// add book to list
		allBooks.add(bookModel);
		
		// return new book with all info including ID
		return bookModel;
	}

	@Override
	public BookModel updateBookCost(BookModel bookModel) {
		// loop through list and find where bookId is equal
		for(int i = 0; i < allBooks.size(); i++) {
			if(allBooks.get(i).getBookId() == bookModel.getBookId()) {
				allBooks.set(i, bookModel);
				
			}
		}
		// return updated book
		return bookModel;
	}

	@Override
	public BookModel deleteBook(int bookId) {
		
		BookModel returnBookModel = null;
		
		// iterate through array list and check if bookId is equal to one in the list
		for(int i = 0; i < allBooks.size(); i++) {
			if(allBooks.get(i).getBookId() == bookId) {
				returnBookModel = allBooks.get(i);
				allBooks.remove(i);
			}
		}
		// return book that was removed, or null
		return returnBookModel;
	}

	@Override
	public BookModel fetchOneBook(int bookId) {
		
		BookModel returnBookModel = null;
		
		// iterate through list and find specific bookId using for loop
//		for(int i = 0; i < allBooks.size(); i++) {
//			if(allBooks.get(i).getBookId() == bookId) {
//				returnBookModel = allBooks.get(i);
//			}
//		}
		
//		// iterate using an iterator
//		Iterator<BookModel> itr = allBooks.iterator();
//		
//		// loop through while there is an element
//		while(itr.hasNext()) {
//			// return the next element
//			BookModel book = itr.next();
//			
//			if(book.getBookId() == bookId) {
//				returnBookModel = book;
//			}
//		}
		
		// iterate ArrayList using enhanced for loop
		for(BookModel book: allBooks) {
			if(book.getBookId() == bookId) {
				returnBookModel = book;
			}
		}
		
		
		// iterating ArrayList using forEach <-- most frequently used
	
		
		
		return returnBookModel;
	}

}
