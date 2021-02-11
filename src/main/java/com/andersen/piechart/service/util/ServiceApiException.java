package com.andersen.piechart.service.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ServiceApiException {

    private final String message;
    private final String details;
}
