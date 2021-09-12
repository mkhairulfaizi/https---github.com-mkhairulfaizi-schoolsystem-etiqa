package com.faizi.school.common;

import com.faizi.school.vm.ErrorVM;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RecordNotFoundException.class})
    protected ResponseEntity<ErrorVM> handleNotFound(Exception ex) {
        return new ResponseEntity(new ErrorVM(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}