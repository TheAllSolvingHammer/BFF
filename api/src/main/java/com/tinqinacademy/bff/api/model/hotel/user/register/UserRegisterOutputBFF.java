package com.tinqinacademy.bff.api.model.hotel.user.register;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class UserRegisterOutputBFF implements OperationOutputBFF {
  private String message;
}
