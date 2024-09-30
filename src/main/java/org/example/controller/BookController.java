package org.example.controller;
import org.example.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/books")
    public List<Book> getBooks() {
        return Arrays.asList(
                new Book(1, "Harry Potter", "9780743273565"),
                new Book(2, "Dune", "9780451524935"),
                new Book(3, "Sapiens A Brief History Of Humankind", "9780061120084")
        );
    }
}

