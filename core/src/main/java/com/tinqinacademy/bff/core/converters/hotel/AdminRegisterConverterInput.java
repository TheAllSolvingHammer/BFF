package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.model.hotel.admin.register.AdminRegisterInputBFF;
import com.tinqinacademy.hotel.api.model.operations.admin.register.AdminRegisterInput;
import org.springframework.core.convert.converter.Converter;

public class AdminRegisterConverterInput implements Converter<AdminRegisterInputBFF, AdminRegisterInput> {
    @Override
    public AdminRegisterInput convert(AdminRegisterInputBFF source) {
        return AdminRegisterInput.builder()
                .authority(source.getAuthority())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .idNumber(source.getIdNumber())
                .issueDate(source.getIssueDate())
                .phone(source.getPhone())
                .validity(source.getValidity())
                .roomID(source.getRoomID())
                .build();
    }
}
