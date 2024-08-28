package com.tinqinacademy.bff.core.processors.comment;


import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.comment.user.update.UpdateCommentInputBFF;
import com.tinqinacademy.bff.api.model.comment.user.update.UpdateCommentOutputBFF;
import com.tinqinacademy.bff.api.model.comment.user.update.UserUpdateOperationBFF;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Slf4j
public class UserUpdateCommentOperationImpl extends BaseProcess implements UserUpdateOperationBFF {


    public UserUpdateCommentOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator) {
        super(conversionService, errorMapper, validator);
    }

    @Override
    public Either<ErrorsProcessorBFF, UpdateCommentOutputBFF> process(UpdateCommentInputBFF input) {
        return null;
    }
}
