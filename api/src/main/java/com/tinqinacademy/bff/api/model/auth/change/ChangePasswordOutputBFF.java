package com.tinqinacademy.bff.api.model.auth.change;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class ChangePasswordOutputBFF implements OperationOutputBFF {
    private String message;
}
