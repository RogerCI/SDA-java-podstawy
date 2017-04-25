package zajecia.oop.bookstore;

import zajecia.Zajecia4;

/**
 * Created by RENT on 2017-04-24.
 */
public class Application {
    public static void main(String[] args) {

        Bookstore bookstore = new Bookstore();

        insertExampleData(bookstore);

        bookstore.showBooks();

        System.out.println(bookstore.getNumberOfBooks("Henryk Sienkiewicz"));

        Book[] booksOfSienkiewicz = bookstore.getBooks("Henryk Sienkiewicz");
        for (int i = 0; i < booksOfSienkiewicz.length; i++) {
            System.out.println(booksOfSienkiewicz[i]);
        }


    }

    public static void insertExampleData(Bookstore bookstore) {
        Book book = new Book("Ogniem i mieczem", "Henryk Sienkiewicz", "2001", "1234567890");
        book.size = 3;

        String[] ogniemIMieczem = new String[3];
        ogniemIMieczem[0] = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        ogniemIMieczem[1] = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";
        ogniemIMieczem[2] = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";
        book.content = ogniemIMieczem;


        Book book2 = new Book("Potop", "Henryk Sienkiewicz", "2002", "1234567890");
        Book book3 = new Book("Pan Wołodyjowski", "Henryk Sienkiewicz", "2003", "1234567890");
        Book book4 = new Book("Quo vadis", "Henryk Sienkiewicz", "2004", "1234567890");

        Book book5 = new Book("Dziady 4", "Adam Mickiewicz", "2002", "1234567890");
        String[] dziady4 = new String[3];
        dziady4[0] = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        dziady4[1] = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";
        dziady4[2] = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.";
        book.content = dziady4;

        bookstore.add(book);
        bookstore.add(book2);
        bookstore.add(book3);
        bookstore.add(book4);
        bookstore.add(book5);
    }

}
