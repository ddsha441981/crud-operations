package com.codewithcup.crudoperations.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GlobalExceptionResponse {

    private Date timestamp;
    private String message;
    private String detail;

}
