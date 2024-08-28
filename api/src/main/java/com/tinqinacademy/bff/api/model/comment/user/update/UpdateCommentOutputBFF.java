package com.tinqinacademy.bff.api.model.comment.user.update;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class UpdateCommentOutputBFF implements OperationOutputBFF {
    private String id;
}
