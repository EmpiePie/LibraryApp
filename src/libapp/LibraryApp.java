package libapp;

import java.util.ArrayList;

public class LibraryApp {
    private BookRepository bookRepo = new BookRepository();

    public void searchByIsbn(String isbn){
        System.out.printf("Searching for books with ISBN: %s\n", isbn);
        Book book = bookRepo.findByIsbn(isbn);
        if (book != null){
            System.out.printf("1 Book Found: \n\tTitle: %s\n\tGenre: %s\n\tAuthor: %s", book.getTitle(), book.getGenre(), book.getAuthor());
        }
        else{
            System.out.printf("0 Books Found.");
        }
        System.out.print("\n\n");
    }
    public void searchByTitle(String keyword){
        System.out.printf("Searching for books with Keyword: %s ", keyword);
        ArrayList<Book> books = bookRepo.findByTitle(keyword);
        System.out.printf("\n\t%s Books Found%s \n", books.size(), books.size() > 0 ? ":" : ".");
        for (Book book : books){
            System.out.printf("\n\tTitle: %s\n\tGenre: %s\n\tAuthor: %s\n\t---\n", book.getTitle(), book.getGenre(), book.getAuthor());
            System.out.println();
        }
    }

    public void checkOutBook(String isbn){
        Book book = bookRepo.findByIsbn(isbn);
        if (book != null){
            if (book.checkOut()){
            System.out.printf("Book Checked Out Successfully:\n");
            System.out.printf("\tISBN: %s\n\tTitle: %s\n\tAuthor: %s\n\n", book.getIsbn(),book.getTitle(), book.getAuthor());
            }
            else{
                System.out.println("Check Out Failed:");
                System.out.printf("\tISBN: %s\n\tTitle: %s\n\tAuthor: %s\n\n", book.getIsbn(),book.getTitle(), book.getAuthor());
                System.out.println("Reason: Checked Out Quantity more than Recorded Quantity.");
            }
        }

        else {
            System.out.printf("\nError: No Book found on record.\n");
        }
    }

    public void checkInBook(String isbn){
        Book book = bookRepo.findByIsbn(isbn);
        if (book != null){
            if (book.checkIn()){
            System.out.printf("Book Checked In Successfully:\n");
            System.out.printf("\tISBN: %s\n\tTitle: %s\n\tAuthor: %s\n\n", book.getIsbn(),book.getTitle(), book.getAuthor());
            }
            else{
                System.out.println("Check In Failed:");
                System.out.printf("\tISBN: %s\n\tTitle: %s\n\tAuthor: %s\n\n", book.getIsbn(),book.getTitle(), book.getAuthor());
                System.out.println("Reason: Checked In Quantity less than 0.");
            }
        }

        else {
            System.out.printf("\nError: No Book found on record.\n");
        }
    }
}
