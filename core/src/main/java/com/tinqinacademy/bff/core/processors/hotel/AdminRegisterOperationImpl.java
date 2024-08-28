package com.tinqinacademy.bff.core.processors.hotel;


import com.tinqinacademy.bff.api.exceptions.ErrorsProcessorBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.register.AdminRegisterInputBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.register.AdminRegisterOperationBFF;
import com.tinqinacademy.bff.api.model.hotel.admin.register.AdminRegisterOutputBFF;
import com.tinqinacademy.bff.core.converters.hotel.AdminRegisterConverterOutput;
import com.tinqinacademy.bff.core.processors.base.BaseProcess;
import com.tinqinacademy.hotel.api.model.operations.admin.register.AdminRegisterOutput;
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
public class AdminRegisterOperationImpl extends BaseProcess implements AdminRegisterOperationBFF {
    private final AdminRegisterConverterOutput outputConverter;
    private final HotelRestExport hotelRestExport;
    @Autowired
    public AdminRegisterOperationImpl(ConversionService conversionService, ErrorsProcessorBFF errorMapper, Validator validator, AdminRegisterConverterOutput converter, HotelRestExport hotelRestExport) {
        super(conversionService, errorMapper, validator);
        this.outputConverter = converter;
        this.hotelRestExport = hotelRestExport;
    }

    @Override
    public Either<ErrorsProcessorBFF, AdminRegisterOutputBFF> process(AdminRegisterInputBFF input) {
        return Try.of(()->{
                    AdminRegisterOutput adminRegisterOutput = hotelRestExport.adminRegister(input.getStartDate(),
                            input.getEndDate(),
                            input.getFirstName(),
                            input.getLastName(),
                            input.getPhone(),
                            input.getIdNumber(),
                            input.getValidity(),
                            input.getAuthority(),
                            input.getIssueDate(),
                            input.getRoomID());
                    return outputConverter.convert(adminRegisterOutput);
        }).toEither()
                .mapLeft(throwable -> ErrorsProcessorBFF.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(throwable.getMessage())
                        .build());
    }

}
