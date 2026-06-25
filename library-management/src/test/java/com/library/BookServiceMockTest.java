package com.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceMockTest {

    @Mock
    private BookService bookService;

    // Exercise 1 — Mocking and Stubbing
    @Test
    void testMockFindBook() {
        // Stub — tell the mock what to return when findBook is called
        when(bookService.findBook("Java Programming")).thenReturn(true);
        when(bookService.findBook("Unknown Book")).thenReturn(false);

        // Assert the stubbed responses
        assertTrue(bookService.findBook("Java Programming"));
        assertFalse(bookService.findBook("Unknown Book"));
    }

    @Test
    void testMockGetBookCount() {
        // Stub — tell the mock to return 5 when getBookCount is called
        when(bookService.getBookCount()).thenReturn(5);

        assertEquals(5, bookService.getBookCount());
    }

    // Exercise 2 — Verifying Interactions
    @Test
    void testVerifyAddBook() {
        // Act
        bookService.addBook("Clean Code");
        bookService.addBook("Clean Code");

        // Verify addBook was called exactly 2 times with "Clean Code"
        verify(bookService, times(2)).addBook("Clean Code");
    }

    @Test
    void testVerifyFindBook() {
        // Act
        bookService.findBook("Design Patterns");

        // Verify findBook was called exactly once
        verify(bookService, times(1)).findBook("Design Patterns");
    }

    @Test
    void testVerifyNoMoreInteractions() {
        // Act
        bookService.addBook("Refactoring");

        // Verify only addBook was called, nothing else
        verify(bookService).addBook("Refactoring");
        verifyNoMoreInteractions(bookService);
    }
}
