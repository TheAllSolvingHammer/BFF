package com.tinqinacademy.bff.api.model.auth.login;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;
import org.springframework.http.HttpHeaders;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class LoginOutputBFF implements OperationOutputBFF {
    private HttpHeaders headers;
}
