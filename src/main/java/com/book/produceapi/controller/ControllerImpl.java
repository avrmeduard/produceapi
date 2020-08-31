package com.book.produceapi.controller;

import com.book.produceapi.model.addbook.AddBookResponse;
import com.book.produceapi.model.bookmodel.Book;
import com.book.produceapi.model.getbook.GetBook;
import com.book.produceapi.model.getbook.GetBookResponse;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ControllerImpl implements Controller{

    static ArrayList<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(1, "Starsight", "Brandon Sanderson", "Random House Children's Books",
                "9780593123829", 480, "Engleza", "Young Adult"));
        bookList.add(new Book(2, "Carry On", "Rainbow Rowell", "Pan Macmillan",
                "9781529013009", 528, "Engleza", "Moderni"));
        bookList.add(new Book(3, "Lost Art Of Closing", "Anthony Iannarino", "Penguin Putnam Inc",
                "9780735211698", 240, "Engleza", "Carte straina"));
    }



    @Override
    public GetBookResponse getBook(Optional<Integer> bookId,
                                   HttpServletResponse httpServletResponse) {

        ArrayList<GetBook> getBooks = new ArrayList<>();

        if (bookId.isPresent()) {

            for (Book book : bookList) {

                if (book.getBookId().equals(bookId)) {
                    GetBook bookResponse = new GetBook();
                    bookResponse.setBookId(bookId.get());
                    bookResponse.setTitle(book.getTitle());
                    bookResponse.setAuthor(book.getAuthor());
                    bookResponse.setPublisher(book.getPublisher());
                    bookResponse.setIsbn(book.getIsbn());
                    bookResponse.setNumberOfPages(book.getNumberOfPages());
                    bookResponse.setLanguage(book.getLanguage());
                    bookResponse.setGenre(book.getGenre());

                    getBooks.add(bookResponse);
                } else {

                }
            }

        } else {

            httpServletResponse.setStatus(400);
            GetBookResponse getBookResponse = new GetBookResponse();
            getBookResponse.setResponseDescription("Invalid request !");

            return getBookResponse;

        }


        return null;
    }

    @Override
    public AddBookResponse addBook(@Valid AddBookResponse addBookResponse,
                                   HttpServletResponse httpServletResponse) {
        return null;
    }


}
