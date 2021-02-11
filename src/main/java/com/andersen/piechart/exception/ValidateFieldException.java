package com.andersen.piechart.exception;

import java.io.Serializable;

public class ValidateFieldException extends RuntimeException implements Serializable {

    public ValidateFieldException(String message) {
        super(message);
    }
}
