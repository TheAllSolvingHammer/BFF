package com.tinqinacademy.bff.api.model.hotel.admin.delete;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class AdminDeleteOutputBFF implements OperationOutputBFF {
    private String message;
}
