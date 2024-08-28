package com.tinqinacademy.bff.api.model.auth.change;

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
public class ChangePasswordInputBFF implements OperationInputBFF {
    @NotNull(message = "Old password can not be null")
    private String oldPassword;
    @NotNull(message = "New password can not be null")
    private String newPassword;
    @Email(message = "Input is not email")
    private String email;
}
