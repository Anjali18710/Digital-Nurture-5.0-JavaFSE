package com.library;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookServiceSetupTest {

    private BookService service;

    // Runs BEFORE every single test — this is the Setup
    @BeforeEach
    void setUp() {
        service = new BookService();
        service.addBook("Java Programming");
        service.addBook("Clean Code");
        service.addBook("Design Patterns");
        System.out.println("Setup done — BookService ready with 3 books");
    }

    // Runs AFTER every single test — this is the Teardown
    @AfterEach
    void tearDown() {
        service = null;
        System.out.println("Teardown done — BookService cleared");
    }

    // AAA Pattern: Arrange → Act → Assert
    @Test
    void testAddBook() {
        // Arrange — already done in setUp()

        // Act
        service.addBook("Refactoring");

        // Assert
        assertEquals(4, service.getBookCount(), "Should have 4 books after adding one");
    }

    @Test
    void testFindBook() {
        // Arrange — already done in setUp()

        // Act
        boolean found = service.findBook("Clean Code");

        // Assert
        assertTrue(found, "Clean Code should be found");
    }

    @Test
    void testRemoveBook() {
        // Arrange — already done in setUp()

        // Act
        service.removeBook("Java Programming");

        // Assert
        assertEquals(2, service.getBookCount(), "Should have 2 books after removal");
        assertFalse(service.findBook("Java Programming"), "Removed book should not be found");
    }

    @Test
    void testBookNotFound() {
        // Arrange — already done in setUp()

        // Act
        boolean found = service.findBook("Unknown Book");

        // Assert
        assertFalse(found, "Unknown book should not be found");
    }
}
