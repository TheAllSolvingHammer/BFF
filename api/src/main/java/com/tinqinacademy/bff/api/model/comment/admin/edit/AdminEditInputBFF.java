package com.tinqinacademy.bff.api.model.comment.admin.edit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder(toBuilder = true)
public class AdminEditInputBFF implements OperationInputBFF {
    @JsonIgnore
    private String commentID;
    @NotBlank(message = "RoomID an not be blank")
    private String roomID;
    @NotBlank(message = "First name not be blank")
    private String firstName;
    @NotBlank(message = "Last name can not be blank")
    private String lastName;
    @NotBlank(message = "Content can not be blank")
    private String content;
}
