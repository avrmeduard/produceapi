package com.book.produceapi.controller;

import com.book.produceapi.model.addbook.AddBookRequest;
import com.book.produceapi.model.addbook.AddBookResponse;
import com.book.produceapi.model.errormodel.ErrorResponse;
import com.book.produceapi.model.getbook.GetBookResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@Api(value = "getBook / addBook",
     description = "Rest API for book")
public interface Controller {


    @ApiOperation(value = "Get book", nickname = "getBook")
    @ApiResponses(value = {@ApiResponse(code = HttpServletResponse.SC_OK,
                                        message = "Result matching criteria",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND,
                                        message = "No entry found",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST,
                                        message = "Invalid request",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED,
                                        message = "Method not allowed",
                                        response = ErrorResponse.class) })
    @GetMapping("/getBook")
    GetBookResponse getBook(@RequestParam Optional<Integer> bookId,
                             HttpServletResponse httpServletResponse);





    @PostMapping("/addBook")
    AddBookResponse addBook(@RequestBody @Valid AddBookRequest addBookRequest,
                            HttpServletResponse httpServletResponse);
}
