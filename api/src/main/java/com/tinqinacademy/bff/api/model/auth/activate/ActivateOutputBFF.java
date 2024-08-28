package com.tinqinacademy.bff.api.model.auth.activate;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class ActivateOutputBFF implements OperationOutputBFF {
    private String message;
}
