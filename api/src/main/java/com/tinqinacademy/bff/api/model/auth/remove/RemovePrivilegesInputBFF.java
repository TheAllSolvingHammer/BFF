package com.tinqinacademy.bff.api.model.auth.remove;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class RemovePrivilegesInputBFF implements OperationInputBFF {
    private UUID id;
}
