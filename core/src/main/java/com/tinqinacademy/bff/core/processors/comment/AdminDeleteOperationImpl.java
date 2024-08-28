package com.tinqinacademy.bff.core.processors.comment;


import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.comment.admin.delete.AdminDeleteInputBFF;
import com.tinqinacademy.bff.api.model.comment.admin.delete.AdminDeleteOperationBFF;
import com.tinqinacademy.bff.api.model.comment.admin.delete.AdminDeleteOutputBFF;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.comment.api.model.admin.delete.AdminDeleteOutput;
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
public class AdminDeleteOperationImpl extends BaseProcess implements AdminDeleteOperationBFF {
    private final CommentClient client;

    public AdminDeleteOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, CommentClient client) {
        super(conversionService, errorMapper, validator);
        this.client = client;
    }

    @Override
    public Either<ErrorsProcessorBFF, AdminDeleteOutputBFF> process(AdminDeleteInputBFF input) {
        return  Try.of(()->{
                    AdminDeleteOutput adminDeleteOutput = client.deleteSystemComment(input.getCommentID());
                    return AdminDeleteOutputBFF.builder()
                            .message(adminDeleteOutput.getMessage())
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
