package com.tinqinacademy.bff.api.model.hotel.admin.register;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class AdminRegisterInputBFF implements OperationInputBFF {

    private LocalDate startDate;

    private LocalDate endDate;
    @NotBlank(message = "First name can not be blank")
    private String firstName;
    @NotBlank(message = "Last name can not be blank")
    private String lastName;
    @NotBlank(message = "Phone can not be blank")
    @Size(min=10, max =15, message = "Phone number must be between 10 and 15 digits")
    private String phone;
    @NotBlank(message = "Room ID can not be blank")
    private String idNumber;
    private LocalDate validity;
    @NotBlank(message = "Authority can not be blank")
    private String authority;
    @PastOrPresent(message = "Issue date can not be in the future")
    private LocalDate issueDate;
    private String roomID;
}
