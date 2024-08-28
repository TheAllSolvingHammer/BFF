package com.tinqinacademy.bff.core.processors.comment;

import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.comment.user.leave.LeaveCommentInputBFF;
import com.tinqinacademy.bff.api.model.comment.user.leave.LeaveCommentOutputBFF;
import com.tinqinacademy.bff.api.model.comment.user.leave.UserLeaveCommentOperationBFF;
import com.tinqinacademy.bff.core.converters.comment.LeaveCommentConverter;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.comment.api.model.user.leave.LeaveCommentInput;
import com.tinqinacademy.comment.api.model.user.leave.LeaveCommentOutput;
import com.tinqinacademy.comment.restexport.CommentClient;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserLeaveCommentOperationImpl extends BaseProcess implements UserLeaveCommentOperationBFF {
    private final LeaveCommentConverter converter;
    private final CommentClient commentClient;

    public UserLeaveCommentOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, LeaveCommentConverter converter, CommentClient commentClient) {
        super(conversionService, errorMapper, validator);
        this.converter = converter;
        this.commentClient = commentClient;
    }

    @Override
    public Either<ErrorsProcessorBFF, LeaveCommentOutputBFF> process(LeaveCommentInputBFF input) {
        return  Try.of(()->{
                    LeaveCommentInput converted = converter.convert(input);
                    LeaveCommentOutput leaveCommentOutput = commentClient.leaveComment(input.getRoomID(), converted);
                    return LeaveCommentOutputBFF.builder()
                            .id(leaveCommentOutput.getId())
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> ErrorsProcessorBFF.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(throwable.getMessage())
                        .build());
    }
}
