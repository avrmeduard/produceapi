package com.book.produceapi.error;

import com.book.produceapi.controller.ControllerImpl;
import com.book.produceapi.model.errormodel.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;


@RestControllerAdvice
public class ErrorSolver {

    private Logger log = LoggerFactory.getLogger(ControllerImpl.class);

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception,
                                                                   HttpServletResponse httpServletResponse){

        ErrorResponse response = new ErrorResponse();
        response.setErrorDescription(exception.getMessage());
        httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        log.info("Error MethodArgumentTypeMismatchException found");
        log.warn("Error has been found returning status: " + HttpServletResponse.SC_BAD_REQUEST);

        return response;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ErrorResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception,
                                                                      HttpServletResponse servletResponse) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorDescription("Method not allowed");
        servletResponse.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

        log.info("Error HttpRequestMethodNotSupportedException found");
        log.warn("Error has been found returning status: " + HttpServletResponse.SC_METHOD_NOT_ALLOWED);

        return response;
    }

    @ExceptionHandler(NumberFormatException.class)
    public ErrorResponse handleNumberFormatException(NumberFormatException exception,
                                                                      HttpServletResponse servletResponse) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorDescription("Only numbers allowed" + exception.getMessage());
        servletResponse.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

        log.info("Error NumberFormatException found");
        log.warn("Error has been found returning status: " + HttpServletResponse.SC_METHOD_NOT_ALLOWED);

        return response;
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ErrorResponse handleConversionFailedException(ConversionFailedException exception,
                                                                      HttpServletResponse servletResponse) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorDescription("Only numbers allowed");
        servletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        log.info("Error ConversionFailedException found");
        log.warn("Error has been found returning status: " + HttpServletResponse.SC_BAD_REQUEST);

        return response;
    }

}
