package com.tinqinacademy.bff.api.model.auth.register;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class UserRegistrationOutputBFF implements OperationOutputBFF {
    private UUID id;
}
