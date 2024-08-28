package com.tinqinacademy.bff.api.model.auth.validate;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class ValidateOutputBFF implements OperationOutputBFF {
    private Boolean isValid;
}
