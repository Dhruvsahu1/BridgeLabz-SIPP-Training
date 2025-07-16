import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class BookShelf {
   
    private Map genreToBooksMap;
    
    private HashSet bookSet;

    
    public BookShelf() {
        genreToBooksMap = new HashMap();
        bookSet = new HashSet();
    }


    public void addBook(String genre, String bookTitle) {
        
        if (!bookSet.contains(bookTitle)) {
            
            if (!genreToBooksMap.containsKey(genre)) {
                genreToBooksMap.put(genre, new LinkedList());
            }
           
            ((LinkedList) genreToBooksMap.get(genre)).add(bookTitle);
           
            bookSet.add(bookTitle);
        } else {
            System.out.println("Book already exists in the library: " + bookTitle);
        }
    }

    
    public void removeBook(String genre, String bookTitle) {
        
        if (genreToBooksMap.containsKey(genre) && ((LinkedList) genreToBooksMap.get(genre)).contains(bookTitle)) {
            
            ((LinkedList) genreToBooksMap.get(genre)).remove(bookTitle);
           
            bookSet.remove(bookTitle);
        } else {
            System.out.println("Book not found in the library: " + bookTitle);
        }
    }

   
    public LinkedList getBooksByGenre(String genre) {
        
        return (LinkedList) genreToBooksMap.getOrDefault(genre, new LinkedList());
    }

    public void printAllBooks() {
        for (Map.Entry entry : (Iterable<Map.Entry>) genreToBooksMap.entrySet()) {
            System.out.println("Genre: " + entry.getKey());
            System.out.println("Books: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.addBook("Fiction", "The Great Gatsby");
        bookShelf.addBook("Fiction", "1984");
        bookShelf.addBook("Non-Fiction", "Sapiens");
        bookShelf.addBook("Non-Fiction", "Sapiens"); 

        bookShelf.printAllBooks();

        // bookShelf.removeBook("Fiction", "1984");
        // bookShelf.removeBook("Fiction", "1984"); 

        // bookShelf.printAllBooks();
    }
}
