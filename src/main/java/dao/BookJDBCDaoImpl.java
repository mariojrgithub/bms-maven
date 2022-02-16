package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BookModel;

public class BookJDBCDaoImpl implements BookDao {

	@Override
	public List<BookModel> fetchAllBooks() {

		// create ArrayList to how all book info from DB
		List <BookModel> allBooks = new ArrayList<>();
		
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			
			String query = "SELECT * FROM book_details";
			
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through result set
			while(rs.next()) {
				// copy each record into a BookModel object
				BookModel bookModel = new BookModel(rs.getInt(1), rs.getString(2), 
											rs.getString(3), rs.getString(4), 
											rs.getInt(5), rs.getString(6));
				
				// add BookModel to ArrayList
				allBooks.add(bookModel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// return ArrayList
		return allBooks;
	}


	@Override
	public BookModel addBook(BookModel bookModel) {
		
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			
			int lastBookId = 0;
			
			// fetch book with max ID
			String query1 = "SELECT MAX(book_id) FROM book_details";
			// execute
			ResultSet rs = stmt.executeQuery(query1);
			
			if(rs.next()) {
				lastBookId = rs.getInt(1);
			}
			
			int newBookId = lastBookId + 1;
						
			String query2 = "INSERT INTO book_details VALUES(" +
								newBookId + ", '" + bookModel.getBookTitle() + "', '" +
								bookModel.getBookAuthor() + "', '" + bookModel.getBookGenre() + "', " + 
								bookModel.getBookCost() + ", '" + bookModel.getBookImageUrl() + "')";
			
			int rows = stmt.executeUpdate(query2);
			
			bookModel.setBookId(newBookId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookModel;
	}

	@Override
	public BookModel updateBookCost(BookModel bookModel) {

		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			
			String query = "UPDATE book_details SET book_cost=" +
								bookModel.getBookCost() + " WHERE book_id=" +
								bookModel.getBookId();
			
			int rows = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bookModel;
	}

	@Override
	public BookModel deleteBook(int bookId) {
		
		BookModel bookModel = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			
			// get book
			bookModel = fetchOneBook(bookId);
			// delete book
			String query = "DELETE FROM book_details WHERE book_id==" + bookId;
			
			int rows = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookModel;
	}

	@Override
	public BookModel fetchOneBook(int bookId) {
		
		BookModel bookModel = null;
		
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			
			String query = "SELECT * FROM book_details WHERE book_id=" + bookId;
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				bookModel = new BookModel(rs.getInt(1), rs.getString(2), 
											rs.getString(3), rs.getString(4), 
											rs.getInt(5), rs.getString(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return bookModel;
	}

}
