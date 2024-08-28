package com.tinqinacademy.bff.api.model.auth.recover;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class PasswordMailRecoverOutputBFF implements OperationOutputBFF {
    private String message;
}
