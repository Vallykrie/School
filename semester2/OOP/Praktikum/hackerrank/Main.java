// package semester2.OOP.Praktikum.hackerrank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The Main class is the entry point of the program.
 * It contains the main method that interacts with the user and controls the
 * LibrarySystem.
 */
public class Main {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        LibrarySystem lib = new LibrarySystem();
        boolean isRunning = true;

        // looping
        while (isRunning) {
            int n = than.nextInt();
            if (than.hasNextLine()) {
                than.nextLine();
            }
            switch (n) {
                case 1:
                    int isbn = than.nextInt();
                    than.nextLine();
                    String title = than.nextLine();
                    String author = than.nextLine();
                    int year = than.nextInt();
                    if (than.hasNextLine()) {
                        than.nextLine();
                    }
                    lib.add(isbn, title, author, year);
                    break;
                case 2:
                    String search = than.nextLine();
                    lib.search(search);
                    break;
                case 3:
                    lib.print();
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option, please choose again.");
                    break;
            }
        }
        than.close();
    }
}

/**
 * The LibrarySystem class represents a library system that manages a collection
 * of books.
 */
class LibrarySystem {
    private Set<Book> bookList;

    /**
     * Constructs a LibrarySystem object with an empty book list.
     */
    public LibrarySystem() {
        this.bookList = new TreeSet<>(new Compare());
    }

    /**
     * Adds a book to the library system.
     * 
     * @param isbn   the ISBN of the book
     * @param title  the title of the book
     * @param author the author of the book
     * @param year   the year the book was published
     * @return true if the book is added successfully, false if the book already
     *         exists in the catalog
     */
    public boolean add(int isbn, String title, String author, int year) {
        Book book = new Book(isbn, title, author, year);
        System.out
                .println(bookList.contains(book) ? "Book already exists in the catalog." : "Book added successfully!");
        boolean add = !bookList.contains(book) ? bookList.add(book) : false;
        return add;
    }

    /**
     * Searches for a book in the library system by title.
     * 
     * @param title the title of the book to search for
     */
    public void search(String title) {
        boolean isFound = false;
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("No book found with the title: " + title);
        }
    }

    /**
     * Prints the list of books in the library system.
     */
    public void print() {
        System.out.println(bookList.isEmpty() ? "The book catalog is currently empty."
                : bookList.stream().map(Object::toString).collect(Collectors.joining("\n")));
    }

}

/**
 * The Book class represents a book with its ISBN, title, author, and year of
 * publication.
 */
class Book {
    private int isbn;
    private String title;
    private String author;
    private int year;

    /**
     * Constructs a Book object with the specified ISBN, title, author, and year of
     * publication.
     * 
     * @param isbn   the ISBN of the book
     * @param title  the title of the book
     * @param author the author of the book
     * @param year   the year the book was published
     */
    public Book(int isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    /**
     * Returns a string representation of the book.
     * 
     * @return a string representation of the book
     */
    @Override
    public String toString() {
        return "Book{isbn='" + isbn + "', title='" + title + "', author='" + author + "', yearPublished=" + year + "}";
    }

    /**
     * Returns the title of the book.
     * 
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the ISBN of the book.
     * 
     * @return the ISBN of the book
     */
    public int getIsbn() {
        return isbn;
    }
}

/**
 * The Compare class is a custom comparator for sorting books based on the
 * length of their ISBN.
 */
class Compare implements Comparator<Book> {
    /**
     * Compares two books based on the length of their ISBN.
     * 
     * @param book1 the first book to compare
     * @param book2 the second book to compare
     * @return a negative integer if book1 has a longer ISBN, a positive integer if
     *         book2 has a longer ISBN, or 0 if their ISBN lengths are equal
     */
    @Override
    public int compare(Book book1, Book book2) {
        int s1 = String.valueOf(book1.getIsbn()).length();
        int s2 = String.valueOf(book2.getIsbn()).length();
        return Integer.compare(s2, s1);
    }
}
