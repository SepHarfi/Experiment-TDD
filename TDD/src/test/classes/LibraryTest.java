package test.classes;

import main.classes.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    @Test
    public void lendBook() {
        Library library = new Library();

        Book book = new Book("Book", "MMV", 1);
        library.addBook(book);

        Student student = new Student("Sepehr", 1);
        assertFalse(library.lendBook(book, student));
    }

    @Test
    public void returnBook() {
        Library library = new Library();

        Book book = new Book("Book", "MMV", 1);
        library.addBook(book);

        Student student = new Student("Sepehr", 1);
        library.addStudent(student);

        assertTrue(library.lendBook(book, student));
        assertTrue(library.returnBook(book, student));
        assertFalse(student.hasBook(book));
    }

}
