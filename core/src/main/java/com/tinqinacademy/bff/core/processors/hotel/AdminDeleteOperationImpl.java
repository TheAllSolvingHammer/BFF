package com.tinqinacademy.bff.core.processors.hotel;

import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.delete.AdminDeleteInputBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.delete.AdminDeleteOperationBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.delete.AdminDeleteOutputBFF;
import com.tinqinacademy.bff.core.converters.hotel.AdminDeleteConverter;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.hotel.api.model.operations.admin.delete.AdminDeleteInput;
import com.tinqinacademy.hotel.api.model.operations.admin.delete.AdminDeleteOutput;
import com.tinqinacademy.hotel.restexport.HotelRestExport;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminDeleteOperationImpl extends BaseProcess implements AdminDeleteOperationBFF {
    private final AdminDeleteConverter adminDeleteConverter;
    private final HotelRestExport restExport;
    @Autowired
    public AdminDeleteOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, AdminDeleteConverter adminDeleteConverter, HotelRestExport restExport) {
        super(conversionService, errorMapper, validator);
        this.adminDeleteConverter = adminDeleteConverter;
        this.restExport = restExport;
    }

    @Override
    public Either<ErrorsProcessorBFF, AdminDeleteOutputBFF> process(AdminDeleteInputBFF input) {
        return Try.of(()->{
            AdminDeleteInput adminDeleteInput = adminDeleteConverter.convert(input);
            AdminDeleteOutput adminDeleteOutput = restExport.adminDelete(adminDeleteInput.getID());
            return AdminDeleteOutputBFF.builder()
                    .message(adminDeleteOutput.getMessage())
                    .build();

        }).toEither()
                .mapLeft(throwable -> ErrorsProcessorBFF.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(throwable.getMessage())
                        .build());
    }


}
