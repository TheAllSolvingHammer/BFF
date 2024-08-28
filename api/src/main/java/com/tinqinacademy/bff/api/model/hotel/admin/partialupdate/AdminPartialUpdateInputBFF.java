package com.tinqinacademy.bff.api.model.hotel.admin.partialupdate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder(toBuilder = true)
public class AdminPartialUpdateInputBFF implements OperationInputBFF {
    @JsonIgnore
    private UUID roomID;
    private List<String> bedTypes;
    private String bathRoom;
    @Positive(message = "Floor can not be negative or zero")
    @PositiveOrZero(message="Price can not be negative")
    private BigDecimal price;
    private String roomNumber;
}
