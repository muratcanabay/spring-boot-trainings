package com.muratcanabay.exception.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String description;
}
