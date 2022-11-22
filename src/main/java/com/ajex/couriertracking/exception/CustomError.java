package com.ajex.couriertracking.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public enum CustomError {

    //Common Error

    INTERNAL_SERVER_ERROR("Internal Server Error", 500),
    DATA_NOT_FOUND("Not Found", 404),

    DATABASE_EXCEPTION("Database error", 500);

    private String message;
    private int statusCode;

    CustomError(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    CustomError(HttpStatus status) {
        this.statusCode = status.value();
        this.message = status.getReasonPhrase();
    }
}
