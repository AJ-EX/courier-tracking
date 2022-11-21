package com.ajex.couriertracking.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class CTServiceException extends RuntimeException{
    private String errorMessage;
    private Integer statusCode;

    public CTServiceException(String errorMessage, Integer statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }
    public CTServiceException(HttpStatus status){
        this.errorMessage = status.getReasonPhrase();
        this.statusCode = status.value();
    }
    public CTServiceException(CustomError error){
        this.errorMessage = error.getMessage();
        this.statusCode = error.getStatusCode();
    }
}
