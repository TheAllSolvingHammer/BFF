package com.tinqinacademy.bff.api.model.comment.user.get;

import com.tinqinacademy.bff.api.base.OperationOutputBFF;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class GetCommentsOutputBFF implements OperationOutputBFF {
    private List<GetCommentsOutputItemBFF> commentsOutputList;
}
