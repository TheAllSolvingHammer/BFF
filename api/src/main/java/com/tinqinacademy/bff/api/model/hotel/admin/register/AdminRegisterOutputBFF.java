package com.tinqinacademy.bff.api.model.hotel.admin.register;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class AdminRegisterOutputBFF implements OperationOutputBFF {
    private List<String> data;
    private LocalDate startDate;
    private LocalDate endDate;
    private String firstName;
    private String lastName;
    private String phone;
    private String idNumber;
    private LocalDate validity;
    private String authority;
    private LocalDate issueDate;
    private String roomID;
}
