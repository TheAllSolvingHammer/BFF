package com.tinqinacademy.bff.api.model.hotel.admin.partialupdate;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class AdminPartialUpdateOutputBFF implements OperationOutputBFF {
    private String ID;
}
