package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.BookModel;

public class BookJDBCDaoImpl implements BookDao {

	@Override
	public List<BookModel> fetchAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookModel addBook(BookModel bookModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookModel updateBookCost(BookModel bookModel) {
		// TODO Auto-generated method stub
		return null;
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
