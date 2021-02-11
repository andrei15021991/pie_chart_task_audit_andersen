package com.andersen.piechart.controller.handler;


import com.andersen.piechart.exception.PieChartException;
import com.andersen.piechart.exception.ValidateFieldException;
import com.andersen.piechart.service.util.ServiceApiException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
@Log4j2
public class CustomExceptionHandler {

    @ExceptionHandler(PieChartException.class)
    public final ResponseEntity<?> handleException(PieChartException ex, WebRequest request) {
        log.error(ex.getMessage(), ex);

        return new ResponseEntity<>(new ServiceApiException(ex.getMessage(), request.getDescription(false)), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidateFieldException.class)
    public final ResponseEntity<?> handleException(ValidateFieldException ex, WebRequest request) {
        log.error(ex.getMessage(), ex);

        return new ResponseEntity<>(new ServiceApiException(ex.getMessage(), request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }
}
