package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.model.hotel.user.register.UserItemBFF;
import com.tinqinacademy.bff.api.model.hotel.user.register.UserRegisterInputBFF;
import com.tinqinacademy.hotel.api.model.operations.user.register.UserItem;
import com.tinqinacademy.hotel.api.model.operations.user.register.UserRegisterInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRegisterConverter implements Converter<UserRegisterInputBFF, UserRegisterInput> {
    @Override
    public UserRegisterInput convert(UserRegisterInputBFF source) {
        return UserRegisterInput.builder()
                .users(convertUsers(source.getUsers()))
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .roomNumber(source.getRoomNumber())
                .build();
    }
    private List<UserItem> convertUsers(List<UserItemBFF> given){
        return given.stream()
                .map(u -> UserItem.builder()
                .authority(u.getAuthority())
                .firstName(u.getFirstName())
                .lastName(u.getLastName())
                .validity(u.getValidity())
                .issueDate(u.getIssueDate())
                .idNumber(u.getIdNumber())
                .dateOfBirth(u.getDateOfBirth())
                .phone(u.getPhone())
                .build())
                .toList();
    }
}
