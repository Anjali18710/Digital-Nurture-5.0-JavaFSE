package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookServiceAssertionsTest {

    @Test
    void testAssertEquals() {
        BookService service = new BookService();
        service.addBook("Java Programming");
        service.addBook("Clean Code");
        assertEquals(2, service.getBookCount(), "Book count should be 2");
    }

    @Test
    void testAssertTrue() {
        BookService service = new BookService();
        service.addBook("Design Patterns");
        assertTrue(service.findBook("Design Patterns"), "Book should exist");
    }

    @Test
    void testAssertFalse() {
        BookService service = new BookService();
        assertFalse(service.findBook("Unknown Book"), "Book should not exist");
    }

    @Test
    void testAssertNotNull() {
        BookService service = new BookService();
        assertNotNull(service, "BookService should not be null");
    }

    @Test
    void testAssertNull() {
        String book = null;
        assertNull(book, "Book should be null");
    }
    @Test
void testAssertThrows() {
    BookService service = new BookService();
    assertThrows(NullPointerException.class, () -> {
        String book = null;
        book.toString(); // this will throw NullPointerException
    });
}
}