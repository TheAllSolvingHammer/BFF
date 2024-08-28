package com.tinqinacademy.bff.api.model.comment.admin.edit;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder(toBuilder = true)
public class AdminEditOutputBFF implements OperationOutputBFF {
    private String id;
}
