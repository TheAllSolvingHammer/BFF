package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.model.hotel.user.book.UserBookInputBFF;
import com.tinqinacademy.hotel.api.model.operations.user.book.UserBookInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserBookConverter implements Converter<UserBookInputBFF, UserBookInput> {
    @Override
    public UserBookInput convert(UserBookInputBFF source) {
        return UserBookInput.builder()
                .email(source.getEmail())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .dateOfBirth(source.getDateOfBirth())
                .phoneNo(source.getPhoneNo())
                .build();

    }
}
