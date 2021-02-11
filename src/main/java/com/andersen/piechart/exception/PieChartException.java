package com.andersen.piechart.exception;

import java.io.Serializable;

public class PieChartException extends RuntimeException implements Serializable {

    public PieChartException(String message) {
        super(message);
    }


}
