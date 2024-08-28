package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.model.hotel.admin.create.AdminCreateInputBFF;
import com.tinqinacademy.hotel.api.model.operations.admin.create.AdminCreateInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdminCreateConverter implements Converter<AdminCreateInputBFF, AdminCreateInput> {
    @Override
    public AdminCreateInput convert(AdminCreateInputBFF source) {
        return AdminCreateInput.builder()
                .roomNumber(source.getRoomNumber())
                .floor(source.getFloor())
                .price(source.getPrice())
                .bathRoom(source.getBathRoom())
                .bedType(source.getBedType())
                .build();
    }
}
