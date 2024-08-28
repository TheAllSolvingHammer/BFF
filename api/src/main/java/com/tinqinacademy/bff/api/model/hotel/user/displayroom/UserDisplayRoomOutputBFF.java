package com.tinqinacademy.bff.api.model.hotel.user.displayroom;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import com.tinqinacademy.bff.api.enums.BathRoomBFF;
import com.tinqinacademy.bff.api.enums.BedBFF;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class UserDisplayRoomOutputBFF implements OperationOutputBFF {
    private UUID ID;
    private BigDecimal price;
    private Integer floor;
    private List<BedBFF> bedSize;
    private BathRoomBFF bathRoom;
    private List<List<LocalDate>> datesOccupied;
}
