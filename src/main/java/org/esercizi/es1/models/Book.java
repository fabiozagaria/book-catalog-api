package org.esercizi.es1.models;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Book {
    private Long id;

    @NotBlank(message = "Titolo obbligatorio")
    private String title;

    @NotBlank(message = "Autore obbligatorio")
    private String author;

    @NotBlank(message = "ISBN obbligatorio")
    private String isbn;

    @NotNull(message = "Prezzo obbligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "Il prezzo deve essere maggiore di zero")
    private BigDecimal price;

    @NotNull(message = "Data obbligatoria")
    @PastOrPresent(message = "Non puoi inserire valori futuri")
    private LocalDate publicationDate;

    public Book() {

    }

    public Book(String title, String author, String isbn, BigDecimal price, LocalDate publicationDate) {
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        setPrice(price);
        setPublicationDate(publicationDate);
    }

    public Book(Long id, String title, String author, String isbn, BigDecimal price, LocalDate publicationDate) {
        setId(id);
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        setPrice(price);
        setPublicationDate(publicationDate);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }
}
