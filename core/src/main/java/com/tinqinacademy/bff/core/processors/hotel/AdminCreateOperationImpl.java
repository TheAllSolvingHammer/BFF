package com.tinqinacademy.bff.core.processors.hotel;


import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.create.AdminCreateInputBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.create.AdminCreateOperationBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.create.AdminCreateOutputBFF;
import com.tinqinacademy.bff.core.converters.hotel.AdminCreateConverter;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.hotel.api.model.operations.admin.create.AdminCreateInput;
import com.tinqinacademy.hotel.api.model.operations.admin.create.AdminCreateOutput;
import com.tinqinacademy.hotel.restexport.HotelRestExport;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminCreateOperationImpl extends BaseProcess implements AdminCreateOperationBFF {
    private final AdminCreateConverter converter;
    private final HotelRestExport restExport;
    public AdminCreateOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, AdminCreateConverter converter, HotelRestExport restExport) {
        super(conversionService, errorMapper, validator);
        this.converter = converter;
        this.restExport = restExport;
    }


    @Override
    public Either<ErrorsProcessorBFF, AdminCreateOutputBFF> process(AdminCreateInputBFF input) {
        return Try.of(()->{
                    AdminCreateInput adminCreateInput = converter.convert(input);
                    AdminCreateOutput adminCreateOutput = restExport.adminCreate(adminCreateInput);
                    return AdminCreateOutputBFF.builder()
                            .ID(adminCreateOutput.getID())
                            .roomNumber(adminCreateOutput.getRoomNumber())
                            .build();

                }).toEither()
                .mapLeft(throwable -> ErrorsProcessorBFF.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(throwable.getMessage())
                        .build());
    }


}
