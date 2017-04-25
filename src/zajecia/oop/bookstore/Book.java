package zajecia.oop.bookstore;

import java.util.Arrays;

/**
 * Created by RENT on 2017-04-24.
 */
public class Book {

    public String title;
    public String description;
    public String author;
    public String releaseDate;
    public int size;
    public String ISBN;
    public String[] content;

    public Book(String title, String author, String releaseDate, String ISBN) { //piszac ten konstruktor tracimy ten domyslny Book()
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.ISBN = ISBN;
        this.description = "To be updated";
    }

    //tworzenie tego: alx + insert, potem wybierz toString
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
