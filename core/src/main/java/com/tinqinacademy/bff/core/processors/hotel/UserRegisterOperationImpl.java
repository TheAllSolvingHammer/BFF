package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;

import com.tinqinacademy.bff.api.model.hotel.user.register.UserRegisterInputBFF;
import com.tinqinacademy.bff.api.model.hotel.user.register.UserRegisterOperationBFF;
import com.tinqinacademy.bff.api.model.hotel.user.register.UserRegisterOutputBFF;
import com.tinqinacademy.bff.core.converters.hotel.UserRegisterConverter;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.hotel.api.model.operations.user.register.UserRegisterInput;
import com.tinqinacademy.hotel.api.model.operations.user.register.UserRegisterOutput;
import com.tinqinacademy.hotel.restexport.HotelRestExport;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserRegisterOperationImpl extends BaseProcess implements UserRegisterOperationBFF {
    private final HotelRestExport restExport;
    private final UserRegisterConverter userRegisterConverter;
    @Autowired
    public UserRegisterOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, HotelRestExport restExport, UserRegisterConverter userRegisterConverter) {
        super(conversionService, errorMapper, validator);
        this.restExport = restExport;
        this.userRegisterConverter = userRegisterConverter;
    }

    @Override
    public Either<ErrorsProcessorBFF, UserRegisterOutputBFF> process(UserRegisterInputBFF input) {
        return Try.of(() -> {
                    UserRegisterInput converted = userRegisterConverter.convert(input);
                    UserRegisterOutput registered = restExport.register(converted);
                    return UserRegisterOutputBFF.builder()
                            .message(registered.getMessage())
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


