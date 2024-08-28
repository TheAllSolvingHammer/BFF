package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.model.hotel.admin.partialupdate.AdminPartialUpdateInputBFF;
import com.tinqinacademy.hotel.api.model.operations.admin.partialupdate.AdminPartialUpdateInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdminPartialUpdateConverter implements Converter<AdminPartialUpdateInputBFF, AdminPartialUpdateInput> {
    @Override
    public AdminPartialUpdateInput convert(AdminPartialUpdateInputBFF source) {
        return AdminPartialUpdateInput.builder()
                .roomNumber(source.getRoomNumber())
                .price(source.getPrice())
                .bathRoom(source.getBathRoom())
                .bedTypes(source.getBedTypes())
                .build();
    }
}
