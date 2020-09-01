package com.book.produceapi.controller;

import com.book.produceapi.model.addbook.AddBook;
import com.book.produceapi.model.addbook.AddBookRequest;
import com.book.produceapi.model.addbook.AddBookResponse;
import com.book.produceapi.model.bookmodel.Book;
import com.book.produceapi.model.getbook.GetBook;
import com.book.produceapi.model.getbook.GetBookResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ControllerImpl implements Controller{


    private Logger log = LoggerFactory.getLogger(this.getClass());

    static ArrayList<Book> bookList = new ArrayList<>();
    static {
               bookList.add(new Book(1, "Starsight", "Brandon Sanderson",
                       "Random House Children's Books", "9780593123829", 480,
                       "Engleza", "Young Adult"));

               bookList.add(new Book(2, "Carry On", "Rainbow Rowell",
                       "Pan Macmillan", "9781529013009", 528,
                       "Engleza", "Moderni"));

               bookList.add(new Book(3, "Lost Art Of Closing", "Anthony Iannarino",
                       "Penguin Putnam Inc", "9780735211698", 240,
                       "Engleza", "Carte straina"));
    }



    @Override
    public GetBookResponse getBook(Optional<Integer> bookId,
                                   HttpServletResponse httpServletResponse) {

        log.info("Called /getBook");
        log.debug("Called /getBook witch bookId = " + bookId);

        if (bookId.isPresent()) {

            log.info("BookId is present");
            log.debug("BookId = " + bookId.get());

            ArrayList<GetBook> getBooks = new ArrayList<>();

            for (Book book : bookList) {

                if (book.getBookId().equals(bookId.get())) {

                    GetBook bookResponse = new GetBook();
                    bookResponse.setBookId(bookId.get());
                    bookResponse.setTitle(book.getTitle());
                    bookResponse.setAuthor(book.getAuthor());
                    bookResponse.setPublisher(book.getPublisher());
                    bookResponse.setIsbn(book.getIsbn());
                    bookResponse.setNumberOfPages(book.getNumberOfPages());
                    bookResponse.setLanguage(book.getLanguage());
                    bookResponse.setGenre(book.getGenre());

                    log.info("Book found and added to the list");
                    log.debug("Book found and added: " + bookResponse.toString());

                    getBooks.add(bookResponse);
                }
            }
            if (getBooks.isEmpty()) {

                log.info("No book was found");
                log.debug("No book was found whit bookId = " + bookId.get());

                httpServletResponse.setStatus(404);
                GetBookResponse response = new GetBookResponse();
                response.setResponseDescription("No entries found");

                return response;
            } else {
                log.info("Returning book list");
                log.debug("Returning a number of " + getBooks.size() + " books.");

                httpServletResponse.setStatus(200);
                GetBookResponse response = new GetBookResponse();
                response.setGetBooks(getBooks);
                response.setResponseDescription("Result matching criteria");

                return response;
            }



        }

        log.info("No list of books was found");

        httpServletResponse.setStatus(400);
        GetBookResponse getBookResponse = new GetBookResponse();
        getBookResponse.setResponseDescription("Invalid request !");

        return getBookResponse;
    }

    @Override
    public AddBookResponse addBook(AddBookRequest addBookRequest,
                                   HttpServletResponse httpServletResponse) {
        AddBookResponse addResponse = new AddBookResponse();

        log.info("Called /addBook");
        AddBook addBook = addBookRequest.getBook();
        log.debug("Called /addBook whit book " + addBook.toString());

        for (Book book : bookList) {
            if (book.getIsbn().equals(addBook.getIsbn())) {

                httpServletResponse.setStatus(HttpServletResponse.SC_CONFLICT);
                addResponse.setResponseDescription("Book already exist");

                log.info("Book already exist");
                log.debug("Book " + addBook.toString() + " exist");
            }
        }

        Book book = new Book();

        // find book whit max id
        Optional<Book> bookWhitMaxId = bookList.stream().max(Comparator.comparing(Book::getBookId));

        // add max id + 1 to added book
        Integer maxId = bookWhitMaxId.get().getBookId() + 1;

        book.setBookId(maxId);
        book.setTitle(addBook.getTitle());
        book.setAuthor(addBook.getAuthor());
        book.setPublisher(addBook.getPublisher());
        book.setIsbn(addBook.getIsbn());
        book.setNumberOfPages(addBook.getNumberOfPages());
        book.setLanguage(addBook.getLanguage());
        book.setGenre(addBook.getGenre());

        bookList.add(book);

        log.info("New book created");
        log.debug("Book " + book.toString() + " created");

        httpServletResponse.setStatus(HttpServletResponse.SC_CREATED);

        addResponse.setBookId(book.getBookId());
        addResponse.setResponseDescription("Book " + book.getTitle() + " by " + book.getTitle() +  " added.");

        return addResponse;
    }



}
