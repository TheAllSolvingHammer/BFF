package com.tinqinacademy.bff.api.model.comment.user.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class UpdateCommentInputBFF implements OperationInputBFF {
    @JsonIgnore
    private String commentID;
    @NotBlank(message = "Content can not be blank")
    private String content;

}
