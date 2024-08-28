package com.tinqinacademy.bff.api.model.hotel.user.unbook;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class UserUnbookInputBFF implements OperationInputBFF {
    private UUID bookId;
}
