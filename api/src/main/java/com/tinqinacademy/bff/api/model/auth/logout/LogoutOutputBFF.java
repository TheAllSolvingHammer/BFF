package com.tinqinacademy.bff.api.model.auth.logout;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class LogoutOutputBFF implements OperationOutputBFF {
    private String message;
}
