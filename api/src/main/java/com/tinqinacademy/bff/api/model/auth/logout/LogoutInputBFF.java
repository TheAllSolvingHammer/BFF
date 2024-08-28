package com.tinqinacademy.bff.api.model.auth.logout;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.bff.api.base.OperationInputBFF;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class LogoutInputBFF implements OperationInputBFF {
    @JsonIgnore
    private UUID id;
    @JsonIgnore
    private String jwt;
}
