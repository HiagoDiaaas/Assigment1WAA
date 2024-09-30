package org.example.service;
import org.example.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BookService {

    private final WebClient webClient;

    @Autowired
    public BookService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Book getBookById(int id) {
        return webClient.get()
                .uri("/books")
                .retrieve()
                .bodyToFlux(Book.class)
                .filter(book -> book.getId() == id)
                .next()
                .block();
    }
}

