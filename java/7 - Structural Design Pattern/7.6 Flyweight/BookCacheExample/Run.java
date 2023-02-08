import java.util.HashMap;

class Book {
  private final String title;
  private final String author;
  private final String publisher;

  public Book(String title, String author, String publisher) {
    this.title = title;
    this.author = author;
    this.publisher = publisher;
  }

  @Override
  public String toString() {
    return "Title: " + title + " Author: " + author + " Publisher: " + publisher;
  }
}

class BookFactory {
  private static final HashMap<String, Book> books = new HashMap<>();

  public static Book getBook(String title, String author, String publisher) {
    String key = title + author + publisher;
    if (!books.containsKey(key)) {
      books.put(key, new Book(title, author, publisher));
    }
    return books.get(key);
  }

  public static int getNumberOfBooks() {
    return books.size();
  }
}

public class Main {
  public static void main(String[] args) {
    Book book1 = BookFactory.getBook("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons");
    Book book2 = BookFactory.getBook("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons");
    Book book3 = BookFactory.getBook("To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott & Co.");

    System.out.println(book1);
    System.out.println(book2);
    System.out.println(book3);
    System.out.println("Number of books created: " + BookFactory.getNumberOfBooks());
  }
}