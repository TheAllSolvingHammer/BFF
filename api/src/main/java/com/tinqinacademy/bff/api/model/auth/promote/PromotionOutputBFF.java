package com.tinqinacademy.bff.api.model.auth.promote;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class PromotionOutputBFF implements OperationOutputBFF {
    private String message;
}
