package com.tinqinacademy.bff.core.processors.base;

import com.tinqinacademy.bff.api.base.OperationInputBFF;
import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import io.vavr.control.Either;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Slf4j
public class BaseProcess {
    private final ConversionService conversionService;
    private final ErrorsProcessorBFF errorMapper;
    private final Validator validator;
    @Autowired
    public BaseProcess(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator) {
        this.conversionService = conversionService;
        this.errorMapper = errorMapper;
        this.validator = validator;
    }

    public Either<ErrorsProcessorBFF, OperationInputBFF> validateInput(OperationInputBFF input) {
        Set<ConstraintViolation<OperationInputBFF>> violations = validator.validate(input);
        if (!violations.isEmpty()) {
            List<String> errorMessages = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
            ErrorsProcessorBFF errorsProcessor = ErrorsProcessorBFF.builder()
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .message(String.join(", ", errorMessages))
                    .build();

            return Either.left(errorsProcessor);
        }

        return Either.right(input);
    }

}
