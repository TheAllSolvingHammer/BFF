package com.tinqinacademy.bff.core.processors.hotel;


import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.update.AdminUpdateInputBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.update.AdminUpdateOperationBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.update.AdminUpdateOutputBFF;
import com.tinqinacademy.bff.core.converters.hotel.AdminUpdateConverter;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.hotel.api.model.operations.admin.update.AdminUpdateInput;
import com.tinqinacademy.hotel.api.model.operations.admin.update.AdminUpdateOutput;
import com.tinqinacademy.hotel.restexport.HotelRestExport;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class AdminUpdateOperationImpl extends BaseProcess implements AdminUpdateOperationBFF {
    private final AdminUpdateConverter converter;
    private final HotelRestExport restExport;

    @Autowired
    public AdminUpdateOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, AdminUpdateConverter converter, HotelRestExport restExport) {
        super(conversionService, errorMapper, validator);
        this.converter = converter;
        this.restExport = restExport;
    }


    @Override
    public Either<ErrorsProcessorBFF, AdminUpdateOutputBFF> process(AdminUpdateInputBFF input) {
        return Try.of(() -> {
                    AdminUpdateInput updateInput = converter.convert(input);
                    AdminUpdateOutput adminUpdateOutput = restExport.adminUpdate(input.getRoomID().toString(), updateInput);
                    return AdminUpdateOutputBFF.builder()
                            .ID(adminUpdateOutput.getID())
                            .roomNumber(adminUpdateOutput.getRoomNumber())
                            .build();

                }).toEither()
                .mapLeft(throwable -> ErrorsProcessorBFF.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(throwable.getMessage())
                        .build());

    }

}
