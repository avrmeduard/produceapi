package com.book.produceapi.model.updatebook;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bookId",
        "title",
        "author",
        "publisher",
        "isbn",
        "numberOfPages",
        "language",
        "genre"

})


public class UpdateBook {

    /**
     * Book id.
     */
    @JsonProperty("bookId")
    @JsonPropertyDescription(" Book id.")
    private Integer bookId;

    /**
     * Name of the book.
     */
    @JsonProperty("title")
    @JsonPropertyDescription(" Book title.")
    @NotNull(message = "Book title cannot be null")
    @Size(min = 2, max = 34, message = "Book title should be between 2 and 34 characters, whitespace allowed")
    @Pattern(regexp = "[a-zA-Z ]*", message = "Only letters allowed")
    private String title;

    /**
     * Author of the book.
     */
    @JsonProperty("author")
    @JsonPropertyDescription(" Book author.")
    @NotNull(message = "Book author can't be null")
    @Size(min = 2, max = 34, message = "Book author should be between 2 and 34 characters, whitespace allowed")
    @Pattern(regexp = "[a-zA-Z ]*", message = "Only letters allowed")
    private String author;

    /**
     * Publisher of the book.
     */
    @JsonProperty("publisher")
    @JsonPropertyDescription(" Book publisher.")
    @NotNull(message = "Book publisher  cannot be null")
    @Size(min = 2, max = 50, message = "Book publisher should be between 2 and 34 characters, whitespace allowed")
    @Pattern(regexp = "[a-zA-Z ]*", message = "Only letters allowed")
    private String publisher;

    /**
     * ISBN of the book.
     */
    @JsonProperty("isbn")
    @JsonPropertyDescription(" Book isbn.")
    @NotNull
    @Size(min = 12, max = 32, message = "Wrong isbn format")
    @Pattern(regexp = "[0-9]+", message = "Only numbers allowed")
    private String isbn;

    /**
     * Number of pages from the book.
     */
    @JsonProperty("numberOfPages")
    @JsonPropertyDescription(" Book number of pages.")
    @NotNull
    @Min(value = 10, message = "The number of pages is to low.")
    private Integer numberOfPages;

    /**
     * Language of the book.
     */
    @JsonProperty("language")
    @JsonPropertyDescription(" Book language.")
    @NotNull(message = "Book language cannot be null")
    @Size(min = 2, max = 15, message = "Book language should be between 2 and 15 characters, whitespace allowed")
    @Pattern(regexp = "[a-zA-Z ]*", message = "Only letters allowed")
    private String language;

    /**
     * Genre of the book.
     */
    @JsonProperty("genre")
    @JsonPropertyDescription(" Book genre.")
    @NotNull(message = "Book genre cannot be null")
    @Size(min = 2, max = 34, message = "Book genre should be between 2 and 34 characters, whitespace allowed")
    @Pattern(regexp = "[a-zA-Z ]*", message = "Only letters allowed")
    private String genre;


    /**
     * Book id.
     */
    @JsonProperty("bookId")
    public Integer getBookId() {
        return bookId;
    }

    /**
     * Book id.
     */
    @JsonProperty("bookId")
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * Name of the book.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Name of the book.
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Author of the book.
     */
    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    /**
     * Author of the book.
     */
    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Publisher of the book.
     */
    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    /**
     * Publisher of the book.
     */
    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * ISBN of the book.
     */
    @JsonProperty("isbn")
    public String getIsbn() {
        return isbn;
    }

    /**
     * ISBN of the book.
     */
    @JsonProperty("isbn")
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Number of pages from the book.
     */
    @JsonProperty("numberOfPages")
    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * Number of pages from the book.
     */
    @JsonProperty("numberOfPages")
    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     * Language of the book.
     */
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    /**
     * Language of the book.
     */
    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Genre of the book.
     */
    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    /**
     * Genre of the book.
     */
    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "GetBook{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", language='" + language + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}