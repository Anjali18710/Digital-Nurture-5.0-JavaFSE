package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {

    @Test
    void testAddBook() {
        BookService service = new BookService();
        service.addBook("Java Programming");
        assertEquals(1, service.getBookCount());
    }

    @Test
    void testFindBook() {
        BookService service = new BookService();
        service.addBook("Clean Code");
        assertTrue(service.findBook("Clean Code"));
    }

    @Test
    void testRemoveBook() {
        BookService service = new BookService();
        service.addBook("Design Patterns");
        service.removeBook("Design Patterns");
        assertFalse(service.findBook("Design Patterns"));
    }
}