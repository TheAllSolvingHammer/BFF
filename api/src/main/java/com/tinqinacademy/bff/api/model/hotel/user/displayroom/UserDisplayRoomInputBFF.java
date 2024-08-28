package com.tinqinacademy.bff.api.model.hotel.user.displayroom;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class UserDisplayRoomInputBFF implements OperationInputBFF {
    @NotBlank(message = "Room ID can not be blank")
    private UUID roomID;
}
