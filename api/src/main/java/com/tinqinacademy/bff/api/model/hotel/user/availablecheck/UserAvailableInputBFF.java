package com.tinqinacademy.bff.api.model.hotel.user.availablecheck;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class UserAvailableInputBFF implements OperationInputBFF {
    @FutureOrPresent(message = "Start date can not be in the past")
    private LocalDate startDate;
    @FutureOrPresent(message = "End date can not be in the past")
    private LocalDate endDate;
    private String bathRoom;
    @NotBlank(message = "bed is empty")
    private String bed;
}
