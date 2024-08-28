package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.model.hotel.admin.update.AdminUpdateInputBFF;
import com.tinqinacademy.hotel.api.model.operations.admin.update.AdminUpdateInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdminUpdateConverter implements Converter<AdminUpdateInputBFF, AdminUpdateInput> {
    @Override
    public AdminUpdateInput convert(AdminUpdateInputBFF source) {
        return AdminUpdateInput.builder()
                .bathRoom(source.getBathRoom())
                .floor(source.getFloor())
                .price(source.getPrice())
                .bedSize(source.getBedSize())
                .roomNumber(source.getRoomNumber())
                .build();
    }
}
