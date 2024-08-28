package com.tinqinacademy.bff.api.model.auth.email;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class EmailRecoveryOutputBFF implements OperationOutputBFF {
    private String message;
}
