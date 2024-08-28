package com.tinqinacademy.bff.api.model.auth.activate;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class ActivateInputBFF implements OperationInputBFF {
    @NotNull(message = "Confirmation code can not be null")
    private String confirmationCode;
}
