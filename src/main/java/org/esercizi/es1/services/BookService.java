package org.esercizi.es1.services;

import org.esercizi.es1.models.Book;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> bookList = new ArrayList<>();
    private Long countId = 11L;

    public BookService() {
        bookList.add(new Book(1L, "Clean Code", "Robert C. Martin", "978-0132350884", new BigDecimal("35.50"), LocalDate.of(2008, 8, 1)));
        bookList.add(new Book(2L, "The Pragmatic Programmer", "Andrew Hunt, David Thomas", "978-0135957059", new BigDecimal("42.00"), LocalDate.of(1999, 10, 20)));
        bookList.add(new Book(3L, "Effective Java", "Joshua Bloch", "978-0134685991", new BigDecimal("45.50"), LocalDate.of(2017, 12, 27)));
        bookList.add(new Book(4L, "Domain-Driven Design", "Eric Evans", "978-0321125217", new BigDecimal("55.00"), LocalDate.of(2003, 8, 30)));
        bookList.add(new Book(5L, "Refactoring", "Martin Fowler", "978-0134757599", new BigDecimal("49.99"), LocalDate.of(2018, 11, 28)));
        bookList.add(new Book(6L, "Designing Data-Intensive Applications", "Martin Kleppmann", "978-1449373320", new BigDecimal("38.90"), LocalDate.of(2017, 3, 16)));
        bookList.add(new Book(7L, "Head First Design Patterns", "Eric Freeman", "978-0596007126", new BigDecimal("34.50"), LocalDate.of(2004, 10, 1)));
        bookList.add(new Book(8L, "Clean Architecture", "Robert C. Martin", "978-0134494166", new BigDecimal("33.99"), LocalDate.of(2017, 9, 20)));
        bookList.add(new Book(9L, "Spring Boot in Action", "Craig Walls", "978-1617292545", new BigDecimal("39.99"), LocalDate.of(2015, 12, 1)));
        bookList.add(new Book(10L, "Java Concurrency in Practice", "Brian Goetz", "978-0321349606", new BigDecimal("47.20"), LocalDate.of(2006, 5, 19)));
    }



    public List<Book> getBookListCopy() {
        return List.copyOf(bookList);
    }

    public Book findById(long id) {
        return bookList.stream()
               .filter(book -> book.getId() == id)
               .findFirst()
               .orElseThrow(() -> new IllegalArgumentException("Libro con ID " + id + " non trovato"));
        
    }

    public Book save(Book book) {
        boolean libroDuplicato = bookList.stream()
                .anyMatch(b -> b.getIsbn().equalsIgnoreCase(book.getIsbn()));
        if (libroDuplicato) throw new IllegalArgumentException("Duplicato Codice ISBN Confrontato");

        book.setId(countId++);
        bookList.add(book);
        return book;
    }

    public Book deleteById(long id) {
        Book libroTrovato = findById(id);
        bookList.remove(libroTrovato);
        return libroTrovato;
    }
}
