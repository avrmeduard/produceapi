package com.book.produceapi.error;

import com.book.produceapi.model.errormodel.ErrorResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;


@RestControllerAdvice
public class ErrorSolver {



    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception,
                                                                   HttpServletResponse httpServletResponse){

        ErrorResponse response = new ErrorResponse();
        response.setErrorDescription(exception.getMessage());
        httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        return response;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ErrorResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception,
                                                                      HttpServletResponse servletResponse) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorDescription("Method not allowed");
        servletResponse.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

        return response;
    }
}
