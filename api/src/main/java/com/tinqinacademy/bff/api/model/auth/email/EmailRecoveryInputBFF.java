package com.tinqinacademy.bff.api.model.auth.email;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class EmailRecoveryInputBFF implements OperationInputBFF {
    @Email(message = "Given input is not email")
    private String email;
}
