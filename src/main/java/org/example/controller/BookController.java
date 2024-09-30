package org.example.controller;

import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return Arrays.asList(
                new Book(1, "Harry Potter", "9780743273565"),
                new Book(2, "Dune", "9780451524935"),
                new Book(3, "Sapiens: A Brief History of Humankind", "9780061120084")
        );
    }

    // New endpoint to get a book by ID using WebClient
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }
}
