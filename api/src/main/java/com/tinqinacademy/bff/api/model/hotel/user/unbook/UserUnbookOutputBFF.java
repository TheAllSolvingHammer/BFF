package com.tinqinacademy.bff.api.model.hotel.user.unbook;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class UserUnbookOutputBFF implements OperationOutputBFF {
    private String message;
}
