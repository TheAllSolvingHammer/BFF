package com.tinqinacademy.bff.api.model.auth.validate;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class ValidateInputBFF implements OperationInputBFF {
    @NotNull(message = "Jwt can not be null")
    private String jwt;
}
