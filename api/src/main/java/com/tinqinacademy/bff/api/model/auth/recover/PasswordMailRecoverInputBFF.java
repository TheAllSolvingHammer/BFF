package com.tinqinacademy.bff.api.model.auth.recover;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class PasswordMailRecoverInputBFF implements OperationInputBFF {
    @Email(message = "Not a valid email")
    private String email;
    @NotNull(message = "Code from the email is empty")
    private String code;
    @NotNull(message = "New password can not be empty")
    private String newPassword;
}
