package com.tinqinacademy.bff.api.model.comment.admin.delete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.bff.api.base.OperationInputBFF;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder(toBuilder = true)
public class AdminDeleteInputBFF implements OperationInputBFF {
    @JsonIgnore
    private String commentID;

}
