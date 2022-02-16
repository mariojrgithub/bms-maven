package presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import exception.BooksNotFoundException;
import exception.SystemException;
import model.BookModel;
import service.BookService;
import service.BookServiceImpl;

public class BookMain {

	public static void main(String[] args) {
		
		BookService bookService = new BookServiceImpl();

		Scanner scan = new Scanner(System.in);
		
		char ch = 'y';
		
		while(ch == 'y') {
			
			System.out.println("****************************************");
			System.out.println("\tBook Management System");
			System.out.println("****************************************");
			System.out.println("1. Add a Book");
			System.out.println("2. Update a Book");
			System.out.println("3. Remove a Book");
			System.out.println("4. Fetch All Books");
			System.out.println("5. Exit");
			System.out.println("****************************************");
			System.out.println("Please enter a menu option: ");
			
			int option = scan.nextInt();
			scan.nextLine();
			System.out.println("****************************************");
			
			switch(option) {
				case 1:
					BookModel newBook = new BookModel();
					System.out.println("Enter Book Title: ");
					newBook.setBookTitle(scan.nextLine());
					System.out.println("Enter Book Author: ");
					newBook.setBookAuthor(scan.nextLine());
					System.out.println("Enter Book Genre: ");
					newBook.setBookGenre(scan.nextLine());
					System.out.println("Enter Book Cost: ");
					newBook.setBookCost(scan.nextInt());
					
				BookModel addedBook;
				try {
					addedBook = bookService.addBook(newBook);
					
					System.out.println("New Book ID is: " + addedBook.getBookId());
					System.out.println("New Book Title is: " + addedBook.getBookTitle());
					System.out.println("New Book Genre is: " + addedBook.getBookGenre());
					System.out.println("New Book Cost is: " + addedBook.getBookCost());
				} catch (SystemException e) {
					System.out.println(e.getMessage());
				}
					
					break;
					
				case 2:
					System.out.println("Enter the ID od the book you want to update: ");
					int updateBook = scan.nextInt();
					BookModel fetchedOldBook;
					
					try {
						fetchedOldBook = bookService.fetchOneBook(updateBook);
						
						if(fetchedOldBook == null) {
							System.out.println("Please enter a valid ID!");
							break;
						}
						
						System.out.println("***********************************************");
						System.out.println("Book ID: " + fetchedOldBook.getBookId());
						System.out.println("Book Title: " + fetchedOldBook.getBookTitle());
						System.out.println("Book Author: " + fetchedOldBook.getBookAuthor());
						System.out.println("Book Genre: " + fetchedOldBook.getBookGenre());
						System.out.println("Book Cost: " + fetchedOldBook.getBookCost());
						System.out.println("***********************************************");
						
						System.out.println("Please enter a new cost: ");
						
						fetchedOldBook.setBookCost(scan.nextInt());
						
						bookService.updateBookCost(fetchedOldBook);
						
						System.out.println("Book Updated Successfully!");
						
					} catch (SystemException e) {
						System.out.println(e.getMessage());
					}
						
						break;
						
				case 3:
					System.out.println("Enter the book ID you want to remove: ");
					int bookToDeleteId = scan.nextInt();
					
				BookModel fetchedBook;
				try {
					fetchedBook = bookService.deleteBook(bookToDeleteId);
					
					if(fetchedBook == null) {
						System.out.println("Please enter a valid book ID!");
						break;
					}
					
					System.out.println("***********************************************");
					System.out.println("Book ID: " + fetchedBook.getBookId());
					System.out.println("Book Title: " + fetchedBook.getBookTitle());
					System.out.println("Book Author: " + fetchedBook.getBookAuthor());
					System.out.println("Book Genre: " + fetchedBook.getBookGenre());
					System.out.println("Book Cost: " + fetchedBook.getBookCost());
					System.out.println("***********************************************");
					System.out.println("Are you sure you want to remove this book? (y/n): ");
					
					char deleteOption = scan.next().charAt(0);
					
					System.out.println("***********************************************");
					
					if(deleteOption == 'y') {
						bookService.deleteBook(bookToDeleteId);
						System.out.println("Book removed successfully!");
					}
					
				} catch (SystemException e) {
					System.out.println(e.getMessage());
				}
					
					break;
					
				case 4:
				List<BookModel> allBooks;
				
				try {
					allBooks = bookService.fetchAllBooks();
					// iterate through allBooks
					Iterator<BookModel> itr = allBooks.iterator();
					
					System.out.println("*************************************************************************");
					System.out.println("ID\t\t\tTITLE\t\t\tAUTHOR\t\tGENRE\tCOST");
					
					while(itr.hasNext()) {
						BookModel book = itr.next();
						System.out.println(book.getBookId() + "\t" + book.getBookTitle() + "\t" + book.getBookAuthor() + "\t" + book.getBookGenre() + "\t" + book.getBookCost());
					}
					System.out.println("*************************************************************************");
				
				} catch (SystemException | BooksNotFoundException e) {
					System.out.println(e.getMessage());
				}
					break;
					
				case 5:
					// exit without an issue --> .exit(0)
//					System.out.println("***********************************************");
//					System.out.println("Exiting System...");
//					System.out.println("Thank you for using the Book Management System!");
//					System.out.println("***********************************************");
					
				try {
					bookService.exitApplication();
					
				} catch (SystemException e) {
					System.out.println(e.getMessage());
				}
					
				System.out.println("***********************************************");
				System.out.println("Exiting System...");
				System.out.println("Thank you for using the Book Management System!");
				System.out.println("***********************************************");
				
				scan.close();
				System.exit(0);

			}
			
			System.out.println("Do You Want to Continue? (y/n): ");
			ch = scan.next().charAt(0);
			scan.nextLine();
			
		}
		
		System.out.println("***********************************************");
		System.out.println("Exiting System...");
		System.out.println("Thank you for using the Book Management System!");
		System.out.println("***********************************************");
		
		scan.close();
		System.exit(0);
		
	}

}
