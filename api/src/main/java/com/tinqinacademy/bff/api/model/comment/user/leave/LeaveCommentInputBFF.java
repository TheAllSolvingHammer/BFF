package com.tinqinacademy.bff.api.model.comment.user.leave;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tinqinacademy.bff.api.base.OperationInputBFF;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor()
@AllArgsConstructor()
@Builder(toBuilder = true)
public class LeaveCommentInputBFF implements OperationInputBFF {
    @JsonIgnore
    private String roomID;
    @NotBlank(message = "First name can not be blank")
    private String firstName;
    @NotBlank(message = "Last name can not be blank")
    private String lastName;
    @NotBlank(message = "Content should not be blank")
    private String content;
    @Past
    private LocalDate birthDate;
}
