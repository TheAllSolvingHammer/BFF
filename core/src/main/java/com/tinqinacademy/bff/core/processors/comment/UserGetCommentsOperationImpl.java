package com.tinqinacademy.bff.core.processors.comment;


import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.comment.user.get.GetCommentsInputBFF;
import com.tinqinacademy.bff.api.model.comment.user.get.GetCommentsOutputBFF;
import com.tinqinacademy.bff.api.model.comment.user.get.UserGetCommentsOperationBFF;
import com.tinqinacademy.bff.core.converters.comment.UserGetCommentsConverter;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.comment.api.model.user.get.GetCommentsOutput;
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
public class UserGetCommentsOperationImpl extends BaseProcess implements UserGetCommentsOperationBFF {
    private final CommentClient commentClient;
    private final UserGetCommentsConverter converter;
    public UserGetCommentsOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, CommentClient commentClient, UserGetCommentsConverter converter) {
        super(conversionService, errorMapper, validator);
        this.commentClient = commentClient;
        this.converter = converter;
    }

    @Override
    public Either<ErrorsProcessorBFF, GetCommentsOutputBFF> process(GetCommentsInputBFF input) {
        return  Try.of(()->{
                    GetCommentsOutput comments = commentClient.getComments(input.getRoomID());
                    return converter.convert(comments);
                })
                .toEither()
                .mapLeft(throwable -> ErrorsProcessorBFF.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(throwable.getMessage())
                        .build());
    }
}
