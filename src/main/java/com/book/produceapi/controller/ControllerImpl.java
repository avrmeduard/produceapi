package com.book.produceapi.controller;

import com.book.produceapi.model.addbook.AddBookResponse;
import com.book.produceapi.model.getbook.GetBookResponse;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ControllerImpl implements Controller{

    @Override
    public GetBookResponse getBook(Optional<Integer> bookId,
                                   HttpServletResponse httpServletResponse) {





        return null;
    }

    @Override
    public AddBookResponse addBook(@Valid AddBookResponse addBookResponse,
                                   HttpServletResponse httpServletResponse) {
        return null;
    }


}
