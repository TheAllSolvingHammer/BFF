package com.tinqinacademy.bff.core.processors.hotel;


import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.hotel.user.availablecheck.UserAvailableInputBFF;
import com.tinqinacademy.bff.api.model.hotel.user.availablecheck.UserAvailableOperationBFF;
import com.tinqinacademy.bff.api.model.hotel.user.availablecheck.UserAvailableOutputBFF;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.hotel.api.model.operations.user.availablecheck.UserAvailableOutput;
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
public class UserAvailableOperationImpl extends BaseProcess implements UserAvailableOperationBFF {
    private final HotelRestExport hotelRestExport;

    @Autowired
    public UserAvailableOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, HotelRestExport hotelRestExport) {
        super(conversionService, errorMapper, validator);
        this.hotelRestExport = hotelRestExport;
    }

    @Override
    public Either<ErrorsProcessorBFF, UserAvailableOutputBFF> process(UserAvailableInputBFF input) {
        return Try.of(()-> {
                    UserAvailableOutput userAvailableOutput = hotelRestExport.checkAvailable(
                            input.getStartDate(),
                            input.getEndDate(),
                            input.getBed(),
                            input.getBathRoom());
                    return UserAvailableOutputBFF.builder()
                            .id(userAvailableOutput.getId())
                            .build();
                }).toEither()
                .mapLeft(throwable -> ErrorsProcessorBFF.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(throwable.getMessage())
                        .build());
    }

}
