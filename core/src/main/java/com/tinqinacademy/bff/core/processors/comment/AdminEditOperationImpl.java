package com.tinqinacademy.bff.core.processors.comment;

import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.comment.admin.edit.AdminEditInputBFF;
import com.tinqinacademy.bff.api.model.comment.admin.edit.AdminEditOperationBFF;
import com.tinqinacademy.bff.api.model.comment.admin.edit.AdminEditOutputBFF;
import com.tinqinacademy.bff.core.converters.comment.AdminEditConverter;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.comment.api.model.admin.edit.AdminEditInput;
import com.tinqinacademy.comment.api.model.admin.edit.AdminEditOutput;
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
public class AdminEditOperationImpl extends BaseProcess implements AdminEditOperationBFF {
    private final AdminEditConverter converter;
    private final CommentClient commentClient;
    public AdminEditOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, AdminEditConverter converter, CommentClient commentClient) {
        super(conversionService, errorMapper, validator);
        this.converter = converter;
        this.commentClient = commentClient;
    }

    @Override
    public Either<ErrorsProcessorBFF, AdminEditOutputBFF> process(AdminEditInputBFF input) {
        return  Try.of(()->{
                    AdminEditInput converted = converter.convert(input);
                    AdminEditOutput adminEditOutput = commentClient.updateSystemComment(input.getCommentID(), converted);
                    return AdminEditOutputBFF.builder()
                            .id(adminEditOutput.getId())
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
