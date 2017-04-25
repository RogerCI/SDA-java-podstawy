package zajecia.oop.bookstore;

/**
 * Created by RENT on 2017-04-24.
 */
public class Bookstore {

    public Book[] books;
    public int numberOfBooks;

    public Bookstore() { //konstruktor bezargumentowy
        this.books = new Book[100]; //tablica 100 ksiazek
        this.numberOfBooks = 0;
    }

    public boolean add(Book book) {
        boolean valueToReturn = false;
        if (numberOfBooks < 100) {
            books[numberOfBooks] = book; //na pierwszym wolnym miejscu na polce dodaję nową książkę
            valueToReturn = true;
            numberOfBooks++;
        }
        return valueToReturn;
    }

    public void showBooks() {
        for (int i = 0; i < numberOfBooks; i++) { //w petli wywietlam ksiazki
            System.out.println(books[i]); //nie musze dawac toString, sout wyszuka go sobie sam :)
        }
    }

    public int getNumberOfBooks(String author) {
        //zwraca liczbe ksiazek danego autora
        int counter = 0;
        for (int i = 0; i < numberOfBooks; i++) {
            if (books[i].author.equals(author)) { // lepsza wersja tego: books[i].author == author
                counter++;
            }
        }
        return counter;
    }

    public Book[] getBooks(String author) {
        //zwraca tablice ksiazek danego autora
        Book[] bookToReturn = new Book[getNumberOfBooks(author)]; //dlugosc tablicy obliczam w poprzedniejmetody
        int index = 0; //index nowej tablicy

        //przechodze po wszystkich ksiazkach
        for (int i = 0; i < numberOfBooks; i++) {
            if (books[i].author.equals(author)) {
                bookToReturn[index] = books[i];
                index++;
            }
        }
        return bookToReturn;
    }

    public Book getBook(String author) {
        return null;
    }

}
