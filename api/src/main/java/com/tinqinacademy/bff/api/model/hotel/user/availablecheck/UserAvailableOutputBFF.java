package com.tinqinacademy.bff.api.model.hotel.user.availablecheck;


import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class UserAvailableOutputBFF implements OperationOutputBFF {
   private List<UUID> id;
}
