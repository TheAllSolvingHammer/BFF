package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.hotel.user.displayroom.UserDisplayRoomInputBFF;
import com.tinqinacademy.bff.api.model.hotel.user.displayroom.UserDisplayRoomOperationBFF;
import com.tinqinacademy.bff.api.model.hotel.user.displayroom.UserDisplayRoomOutputBFF;
import com.tinqinacademy.bff.core.converters.hotel.UserDisplayRoomInputConverter;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.hotel.api.model.operations.user.displayroom.UserDisplayRoomOutput;
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
public class UserDisplayRoomOperationImpl extends BaseProcess implements UserDisplayRoomOperationBFF {
    private final UserDisplayRoomInputConverter converter;
    private final HotelRestExport hotelRestExport;
    @Autowired
    public UserDisplayRoomOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, UserDisplayRoomInputConverter converter, HotelRestExport hotelRestExport) {
        super(conversionService, errorMapper, validator);
        this.converter = converter;
        this.hotelRestExport = hotelRestExport;
    }

    @Override
    public Either<ErrorsProcessorBFF, UserDisplayRoomOutputBFF> process(UserDisplayRoomInputBFF input) {
        return Try.of(()-> {
                    UserDisplayRoomOutput displayed = hotelRestExport.display(input.getRoomID());
                    return converter.convert(displayed);
                }).toEither()
                .mapLeft(throwable -> ErrorsProcessorBFF.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(throwable.getMessage())
                        .build());

    }
}