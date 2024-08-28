package com.tinqinacademy.bff.core.processors.hotel;


import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.hotel.user.book.UserBookInputBFF;
import com.tinqinacademy.bff.api.model.hotel.user.book.UserBookOperationBFF;
import com.tinqinacademy.bff.api.model.hotel.user.book.UserBookOutputBFF;
import com.tinqinacademy.bff.core.converters.hotel.UserBookConverter;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.hotel.api.model.operations.user.book.UserBookInput;
import com.tinqinacademy.hotel.api.model.operations.user.book.UserBookOutput;
import com.tinqinacademy.hotel.restexport.HotelRestExport;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserBookOperationImpl extends BaseProcess implements UserBookOperationBFF {
    private final HotelRestExport hotelRestExport;
    private final UserBookConverter userBookConverter;

    public UserBookOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, HotelRestExport hotelRestExport, UserBookConverter userBookConverter) {
        super(conversionService, errorMapper, validator);
        this.hotelRestExport = hotelRestExport;
        this.userBookConverter = userBookConverter;
    }

    @Override
    public Either<ErrorsProcessorBFF, UserBookOutputBFF> process(UserBookInputBFF input) {
        return  Try.of(()->{
                    UserBookInput converted = userBookConverter.convert(input);
                    UserBookOutput booked = hotelRestExport.book(input.getRoomID(), converted);
                    return UserBookOutputBFF.builder()
                            .message(booked.getMessage())
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
