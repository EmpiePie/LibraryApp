package libapp;

import java.util.ArrayList;

public class BookRepository {
    private ArrayList<Book> books = new ArrayList<>();

    public BookRepository(){
        books.add(new Book("83471", "The Dead of Night", "Horror", null, "S.K. Eleton", 6, 3));
        books.add(new Book("24474", "Cheese Balls", "Cooking", null, "H.P. Anderson",8,2));
        books.add(new Book("55122", "Knight's Quest", "Fantasy", null, "F.E. Anvil",12,8));
        books.add(new Book("25932", "Balls of Steel", "Romance", null, "D. Jameson", 6,6));
        books.add(new Book("44339", "Night and Day", "Fantasy", null, "R. Rico",4,1));
        books.add(new Book("69321", "Over Nowhere", "Thriller", null, "A.A. Claus",5,1));
    }

    public Book findByIsbn(String isbn){
        for (Book book : books){
            if (book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }
    public ArrayList<Book> findByTitle(String keyword){
        ArrayList<Book> booksFound = new ArrayList<>();
        for (Book book : books){
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())){
                booksFound.add(book);
            }
        }
        return booksFound;
    }
}
