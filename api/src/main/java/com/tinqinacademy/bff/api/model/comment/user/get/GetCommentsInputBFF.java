package com.tinqinacademy.bff.api.model.comment.user.get;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.bff.api.base.OperationInputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class GetCommentsInputBFF implements OperationInputBFF {
    @JsonIgnore
    private String roomID;
}
