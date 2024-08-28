package com.tinqinacademy.bff.api.model.auth.login;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class LoginInputBFF implements OperationInputBFF {
    @NotNull(message = "Username can not be null")
    private String username;
    @NotNull(message = "Password can not be null")
    private String password;
}
