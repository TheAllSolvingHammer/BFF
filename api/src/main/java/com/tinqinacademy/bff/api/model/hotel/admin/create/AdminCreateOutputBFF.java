package com.tinqinacademy.bff.api.model.hotel.admin.create;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class AdminCreateOutputBFF implements OperationOutputBFF {
    private UUID ID;
    private String roomNumber;
}
