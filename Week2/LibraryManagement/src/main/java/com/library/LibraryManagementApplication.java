package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        // Load the Spring container using our XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Ask Spring for the bookService bean (already wired with BookRepository inside it)
        BookService bookService = (BookService) context.getBean("bookService");

        // Use it
        bookService.registerBook("The Alchemist");
    }
}