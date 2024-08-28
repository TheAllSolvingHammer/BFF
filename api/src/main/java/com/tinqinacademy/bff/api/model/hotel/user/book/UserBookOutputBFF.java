package com.tinqinacademy.bff.api.model.hotel.user.book;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder(toBuilder = true)
public class UserBookOutputBFF implements OperationOutputBFF {
    private String message;
}
