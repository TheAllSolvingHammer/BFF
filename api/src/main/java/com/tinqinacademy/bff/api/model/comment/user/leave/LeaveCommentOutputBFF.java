package com.tinqinacademy.bff.api.model.comment.user.leave;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class LeaveCommentOutputBFF implements OperationOutputBFF {
    private String id;
}
