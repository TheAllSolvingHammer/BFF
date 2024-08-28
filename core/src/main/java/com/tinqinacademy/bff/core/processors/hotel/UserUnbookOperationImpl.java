package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.hotel.user.unbook.UserUnbookInputBFF;
import com.tinqinacademy.bff.api.model.hotel.user.unbook.UserUnbookOperationBFF;
import com.tinqinacademy.bff.api.model.hotel.user.unbook.UserUnbookOutputBFF;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.hotel.api.model.operations.user.unbook.UserUnbookOutput;
import com.tinqinacademy.hotel.restexport.HotelRestExport;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserUnbookOperationImpl extends BaseProcess implements UserUnbookOperationBFF {
    private final HotelRestExport hotelRestExport;

    public UserUnbookOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, HotelRestExport hotelRestExport) {
        super(conversionService, errorMapper, validator);
        this.hotelRestExport = hotelRestExport;
    }

    @Override
    public Either<ErrorsProcessorBFF, UserUnbookOutputBFF> process(UserUnbookInputBFF input) {
        return Try.of(()->{
                    UserUnbookOutput unbooked = hotelRestExport.unbook(input.getBookId().toString());
                    return UserUnbookOutputBFF.builder()
                            .message(unbooked.getMessage())
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
