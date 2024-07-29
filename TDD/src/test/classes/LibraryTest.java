package test.classes;

import main.classes.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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

    @Test
    public void nullReturnForWrongTypeInSearchStudents() {
        Library library = new Library();

        SearchByType author = SearchByType.AUTHOR;
        SearchByType title = SearchByType.TITLE;

        Student student = new Student("Sepehr", 25);

        assertNull(library.searchStudents(author, new ArrayList<>(List.of("Sepehr"))));
        assertNull(library.searchStudents(title, new ArrayList<>(List.of(25))));
    }

    @Test
    public void nullReturnForWrongTypeInSearchBooks() {
        Library library = new Library();

        Book book1 = new Book("Book-1", "Sepehr", 1);
        Book book2 = new Book("Book-2", "MMV", 2);

        library.addBook(book1);
        library.addBook(book2);

        var keys = new ArrayList<Object>(Arrays.asList("Book-1", "Book-2"));

        assertNull(library.searchBooks(SearchByType.NAME, keys));
    }

    @Test
    public void searchStudentsByID() {
        Library library = new Library();

        Student student1 = new Student("Sepehr", 1);
        Student student2 = new Student("MMV", 2);
        Student student3 = new Student("Zahra", 3);

        library.addStudent(student1);
        library.addStudent(student2);
        library.addStudent(student3);

        ArrayList<Student> required = new ArrayList<>();
        required.add(student1);
        required.add(student2);

        ArrayList<Student> students = library.searchStudents(SearchByType.ID, new ArrayList<>(Arrays.asList(1, 2)));
        assertArrayEquals(students.toArray(), required.toArray());
    }

    @Test
    public void searchStudentByName() {
        Library library = new Library();

        Student student1 = new Student("Sepehr", 1);
        Student student2 = new Student("MMV", 2);
        Student student3 = new Student("Zahra", 3);

        library.addStudent(student1);
        library.addStudent(student2);
        library.addStudent(student3);

        ArrayList<Student> required = new ArrayList<>();
        required.add(student1);
        required.add(student2);

        ArrayList<Student> students = library.searchStudents(SearchByType.NAME, new ArrayList<>(Arrays.asList("Sepehr", "MMV")));
        assertArrayEquals(students.toArray(), required.toArray());
    }

    @Test
    public void searchBooksByID() {
        Library library = new Library();

        Book book1 = new Book("Book-1", "Sepehr", 1);
        Book book2 = new Book("Book-2", "MMV", 2);
        Book book3 = new Book("Book-3", "Zahra", 3);


        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        var keys = new ArrayList<Object>(Arrays.asList(1, 3));

        assertEquals(new ArrayList<>(Arrays.asList(book1, book3)), library.searchBooks(SearchByType.ID, keys));
    }

    @Test
    public void searchBooksByTitle() {
        Library library = new Library();

        Book book1 = new Book("Book-1", "Sepehr", 1);
        Book book2 = new Book("Book-2", "MMV", 2);
        Book book3 = new Book("Book-3", "Zahra", 3);


        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        var keys = new ArrayList<Object>(Arrays.asList("Book-1", "Book-2"));

        assertEquals(new ArrayList<>(Arrays.asList(book1, book2)), library.searchBooks(SearchByType.TITLE, keys));
    }

    @Test
    public void searchBooksByAuthor() {
        Library library = new Library();

        Book book1 = new Book("Book-1", "Sepehr", 1);
        Book book2 = new Book("Book-2", "MMV", 2);
        Book book3 = new Book("Book-3", "Zahra", 3);


        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        var keys = new ArrayList<Object>(Arrays.asList("MMV", "Zahra"));

        assertEquals(new ArrayList<>(Arrays.asList(book2, book3)), library.searchBooks(SearchByType.AUTHOR, keys));
    }

    
    @Test
    public void displayLibraryBook() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Library library = new Library();

        Book book = new Book("Book", "MMV", 1);
        library.addBook(book);

        Student student = new Student("Sepehr", 1);
        library.addStudent(student);

        library.displayBooks();

        System.setOut(System.out);

        String expectedOutput  = "Available books in library:\n" + "Book by MMV\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void displayStudentBook() {
        Library library = new Library();

        Book book = new Book("Book", "MMV", 1);
        library.addBook(book);

        Student student = new Student("Sepehr", 1);
        library.addStudent(student);

        library.lendBook(book, student);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        student.displayBooks();

        System.setOut(System.out);

        String expectedOutput  = "Sepehr|1 has these books:\n" + "Book by MMV\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void displayLibraryStudent() {
        Library library = new Library();

        Student student = new Student("Sepehr", 1);
        library.addStudent(student);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        library.displayStudents();

        System.setOut(System.out);

        String expectedOutput  = "Registered students:\n" + "Sepehr|1\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
