package com.tinqinacademy.bff.api.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
@Component
public class ErrorsProcessorBFF {
    private HttpStatus httpStatus;
    private Integer statusCode;
    private String message;
}
