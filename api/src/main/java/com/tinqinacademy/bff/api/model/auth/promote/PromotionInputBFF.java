package com.tinqinacademy.bff.api.model.auth.promote;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class PromotionInputBFF implements OperationInputBFF {
    private UUID id;
}
