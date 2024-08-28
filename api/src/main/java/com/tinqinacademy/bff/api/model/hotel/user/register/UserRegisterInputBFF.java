package com.tinqinacademy.bff.api.model.hotel.user.register;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class UserRegisterInputBFF implements OperationInputBFF {
    @NotBlank(message = "Room name is blank")
    private String roomNumber;
    @FutureOrPresent(message = "Start date can not be in the past")
    private LocalDate startDate;
    @FutureOrPresent(message = "End date can not be in the past")
    private LocalDate endDate;
    List<UserItemBFF> users;
}
