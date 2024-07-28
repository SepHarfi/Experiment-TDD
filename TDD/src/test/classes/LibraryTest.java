package test.classes;

import main.classes.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class LibraryTest {

    @Test
    public void lendBook() {
        Library library = new Library();

        Book book = new Book("Book", "MMV", 1);
        library.addBook(book);

        Student student = new Student("Sepehr", 1);
        assertFalse(library.lendBook(book, student));
    }

}
