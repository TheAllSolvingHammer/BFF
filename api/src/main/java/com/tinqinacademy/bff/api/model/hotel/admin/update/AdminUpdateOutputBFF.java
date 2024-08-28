package com.tinqinacademy.bff.api.model.hotel.admin.update;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class AdminUpdateOutputBFF implements OperationOutputBFF {
    private UUID ID;
    private String roomNumber;
}
