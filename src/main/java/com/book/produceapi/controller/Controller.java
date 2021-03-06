package com.book.produceapi.controller;

import com.book.produceapi.model.addbook.AddBookRequest;
import com.book.produceapi.model.addbook.AddBookResponse;
import com.book.produceapi.model.deletebook.DeleteBookResponse;
import com.book.produceapi.model.errormodel.ErrorResponse;
import com.book.produceapi.model.getbook.GetBookResponse;
import com.book.produceapi.model.updatebook.UpdateBookRequest;
import com.book.produceapi.model.updatebook.UpdateBookResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@Api(value = "getBook / addBook",
     description = "Rest API for book")
public interface Controller {


    /**
     *
     * Get all books
     *
     */
    @ApiOperation(value = "Get all book", nickname = "getAllBook")
    @ApiResponses(value = {@ApiResponse(code = HttpServletResponse.SC_OK,
                                        message = "Result matching criteria",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND,
                                        message = "No entry found",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED,
                                        message = "Method not allowed",
                                        response = ErrorResponse.class) })
    @GetMapping("/getBook")
    GetBookResponse getBook(HttpServletResponse httpServletResponse);



    /**
     *
     * Get book by id
     *
     */
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
    @GetMapping("/getBook/")
    GetBookResponse getBook(@RequestParam Optional<Integer> bookId,
                                          HttpServletResponse httpServletResponse);




    /**
     *
     * Add book by a book model
     *
     */
    @ApiOperation(value = "Add book", nickname = "addBook")
    @ApiResponses(value = {@ApiResponse(code = HttpServletResponse.SC_CREATED,
                                        message = "Book added",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_CONFLICT,
                                        message = "Book already exist",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST,
                                        message = "Invalid request",
                                        response = ErrorResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED,
                                        message = "Method not allowed",
                                        response = ErrorResponse.class) })
    @PostMapping("/addBook")
    AddBookResponse addBook(@RequestBody @Valid AddBookRequest addBookRequest,
                                                HttpServletResponse httpServletResponse);




    /**
     *
     * Update book by a book model
     *
     */
    @ApiOperation(value = "Update book", nickname = "updateBook")
    @ApiResponses(value = {@ApiResponse(code = HttpServletResponse.SC_CREATED,
                                        message = "Book added",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_CONFLICT,
                                        message = "Book already exist",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST,
                                        message = "Invalid request",
                                        response = ErrorResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED,
                                        message = "Method not allowed",
                                        response = ErrorResponse.class) })
    @PutMapping("/updateBook")
    ResponseEntity<UpdateBookResponse> updateBook(@RequestBody @Valid UpdateBookRequest updateBookRequest,
                                                                      HttpServletResponse httpServletResponse);



    /**
     *
     * Delete all books
     *
     */
    @ApiOperation(value = "Delete all book", nickname = "deleteAllBook")
    @ApiResponses(value = {@ApiResponse(code = HttpServletResponse.SC_OK,
                                        message = "All books has been deleted",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND,
                                        message = "No books found",
                                        response = GetBookResponse.class),

                           @ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED,
                                        message = "Method not allowed",
                                        response = ErrorResponse.class) })
    @DeleteMapping("/deleteBook")
    DeleteBookResponse deleteBook(HttpServletResponse httpServletResponse);



    /**
     *
     * Delete book by id
     *
     */
    @ApiOperation(value = "Delete book", nickname = "deleteBook")
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
    @DeleteMapping("/deleteBook/")
    DeleteBookResponse deleteBook(@RequestParam Optional<Integer> bookId,
                                  HttpServletResponse httpServletResponse);
}
