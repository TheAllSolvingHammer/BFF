package com.tinqinacademy.bff.api.model.auth.remove;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class RemovePrivilegesOutputBFF implements OperationOutputBFF {
    private String message;
}
