package com.digitalnurture.orm_learn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save a book
        Book book = new Book();
        book.setTitle("The Alchemist");
        book.setAuthor("Paulo Coelho");
        bookRepository.save(book);

        // Fetch all books and print them
        System.out.println("Books in database:");
        bookRepository.findAll().forEach(b ->
            System.out.println(b.getId() + ": " + b.getTitle() + " by " + b.getAuthor())
        );
    }
}
