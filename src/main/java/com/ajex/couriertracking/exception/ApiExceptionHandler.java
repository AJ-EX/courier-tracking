package com.ajex.couriertracking.exception;

import com.ajex.couriertracking.dto.response.CommonResponse;
import lombok.extern.log4j.Log4j2;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

@ControllerAdvice
@Log4j2
public class ApiExceptionHandler {

    @ExceptionHandler(CTServiceException.class)
    @ResponseBody
    public CommonResponse handleCustomException(CTServiceException e) {
        log.error("Error: {}",e.getErrorMessage());
        e.printStackTrace();
       return new CommonResponse(e.getErrorMessage(),e.getStatusCode(),null);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseBody
    public CommonResponse handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        log.error(e);
        e.printStackTrace();
        return new CommonResponse(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    public CommonResponse handleDataAccessException(DataAccessException e) {
        log.error(e);
        e.printStackTrace();
        return new CommonResponse(CustomError.DATABASE_EXCEPTION.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public CommonResponse handleException(DataIntegrityViolationException  e) {
        log.error(e);
        String error = "Database Error: ";
        if(e.getCause() instanceof ConstraintViolationException){
            error += ((ConstraintViolationException) e.getCause()).getConstraintName();
        }
        e.printStackTrace();
        return new CommonResponse(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String error = e.getBindingResult().getAllErrors()
                .stream()
                .map(item -> item.getDefaultMessage())
                .collect(Collectors.joining(","));
        log.error("request invalid {}",error);
        e.printStackTrace();
        return new CommonResponse("Error Reasons: ".concat( error), 400);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse handleException(Exception  e) {
        log.error(e);
        e.printStackTrace();
        return new CommonResponse(CustomError.INTERNAL_SERVER_ERROR.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
