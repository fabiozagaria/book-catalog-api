package org.esercizi.es1.controllers;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.esercizi.es1.models.Book;
import org.esercizi.es1.services.BookService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;

    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> listBook = bookService.getBookListCopy();


        return ResponseEntity.ok().body(listBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getOneBook(
            @PathVariable(name = "id") long id
    ) {
        Book libroTrovato = bookService.findById(id);
        return ResponseEntity.ok().body(libroTrovato);

    }

    @PostMapping
    public ResponseEntity<Book> postBook(
            @Valid @RequestBody Book book

    ) {
        bookService.save(book);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(book.getId())
                .toUri();
        return ResponseEntity.created(location).body(book);

    }
}
