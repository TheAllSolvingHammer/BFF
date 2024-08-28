package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.model.hotel.admin.delete.AdminDeleteInputBFF;
import com.tinqinacademy.hotel.api.model.operations.admin.delete.AdminDeleteInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdminDeleteConverter implements Converter<AdminDeleteInputBFF, AdminDeleteInput> {

    @Override
    public AdminDeleteInput convert(AdminDeleteInputBFF source) {
        return AdminDeleteInput.builder()
                .ID(source.getID())
                .build();
    }
}
