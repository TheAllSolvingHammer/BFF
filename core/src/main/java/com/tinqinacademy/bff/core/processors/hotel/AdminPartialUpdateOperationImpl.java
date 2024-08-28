package com.tinqinacademy.bff.core.processors.hotel;


import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.partialupdate.AdminPartialUpdateInputBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.partialupdate.AdminPartialUpdateOperationBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.partialupdate.AdminPartialUpdateOutputBFF;
import com.tinqinacademy.bff.core.converters.hotel.AdminPartialUpdateConverter;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.hotel.api.model.operations.admin.partialupdate.AdminPartialUpdateInput;
import com.tinqinacademy.hotel.api.model.operations.admin.partialupdate.AdminPartialUpdateOutput;
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
public class AdminPartialUpdateOperationImpl extends BaseProcess implements AdminPartialUpdateOperationBFF {
    private final AdminPartialUpdateConverter converter;
    private final HotelRestExport restExport;
    @Autowired
    public AdminPartialUpdateOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, AdminPartialUpdateConverter converter, HotelRestExport restExport) {
        super(conversionService, errorMapper, validator);
        this.converter = converter;

        this.restExport = restExport;
    }

    @Override
    public Either<ErrorsProcessorBFF, AdminPartialUpdateOutputBFF> process(AdminPartialUpdateInputBFF input) {
        return Try.of(()->{
            AdminPartialUpdateInput converted = converter.convert(input);
            AdminPartialUpdateOutput adminPartialUpdateOutput = restExport.adminPartialUpdate(input.getRoomID(), converted);
            return AdminPartialUpdateOutputBFF.builder()
                    .ID(adminPartialUpdateOutput.getID())
                    .build();

                }).toEither()
                .mapLeft(throwable -> ErrorsProcessorBFF.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(throwable.getMessage())
                        .build())
                ;
    }


}
