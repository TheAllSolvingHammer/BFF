package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.model.hotel.admin.register.AdminRegisterOutputBFF;
import com.tinqinacademy.hotel.api.model.operations.admin.register.AdminRegisterOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdminRegisterConverterOutput implements Converter<AdminRegisterOutput, AdminRegisterOutputBFF> {
    @Override
    public AdminRegisterOutputBFF convert(AdminRegisterOutput source) {
        return AdminRegisterOutputBFF.builder()
                .data(source.getData())
                .authority(source.getAuthority())
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .idNumber(source.getIdNumber())
                .issueDate(source.getIssueDate())
                .validity(source.getValidity())
                .phone(source.getPhone())
                .roomID(source.getRoomID())
                .build();
    }
}
