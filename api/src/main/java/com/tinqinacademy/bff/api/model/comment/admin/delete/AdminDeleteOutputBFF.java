package com.tinqinacademy.bff.api.model.comment.admin.delete;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDeleteOutputBFF implements OperationOutputBFF {
    private String message;
}
