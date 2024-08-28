package com.tinqinacademy.bff.core.converters.comment;

import com.tinqinacademy.bff.api.model.comment.user.leave.LeaveCommentInputBFF;
import com.tinqinacademy.comment.api.model.user.leave.LeaveCommentInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LeaveCommentConverter implements Converter<LeaveCommentInputBFF, LeaveCommentInput> {
    @Override
    public LeaveCommentInput convert(LeaveCommentInputBFF source) {
        return LeaveCommentInput.builder()
                .content(source.getContent())
                .birthDate(source.getBirthDate())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .roomID(source.getRoomID())
                .build();
    }
}
