package com.tinqinacademy.bff.core.converters.comment;

import com.tinqinacademy.bff.api.model.comment.admin.edit.AdminEditInputBFF;
import com.tinqinacademy.comment.api.model.admin.edit.AdminEditInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdminEditConverter implements Converter<AdminEditInputBFF, AdminEditInput> {
    @Override
    public AdminEditInput convert(AdminEditInputBFF source) {
        return AdminEditInput.builder()
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .content(source.getContent())
                .build();

    }
}
