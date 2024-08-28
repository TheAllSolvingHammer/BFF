package com.tinqinacademy.bff.api.model.hotel.admin.create;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class AdminCreateInputBFF implements OperationInputBFF {
    @NotBlank(message = "Room number can not be blank")
    private String roomNumber;
    @NotNull(message="Bedtypes list is null")
    private List<String> bedType;
    @NotBlank(message="Bathroom can not be blank")
    private String bathRoom;
    @NotNull(message="Floor can not be null")
    @Positive(message = "Floor can not be negative or zero")
    @Max(value=20, message = "Floor can not be more than 20")
    private Integer floor;
    @NotNull(message="Price can not be blank")
    @PositiveOrZero(message = "price can not be negative")
    private BigDecimal price;
}
