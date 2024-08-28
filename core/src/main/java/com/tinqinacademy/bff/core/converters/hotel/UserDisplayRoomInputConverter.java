package com.tinqinacademy.bff.core.converters.hotel;

import com.tinqinacademy.bff.api.enums.BathRoomBFF;
import com.tinqinacademy.bff.api.enums.BedBFF;
import com.tinqinacademy.bff.api.model.hotel.user.displayroom.UserDisplayRoomOutputBFF;
import com.tinqinacademy.hotel.api.enums.Bed;
import com.tinqinacademy.hotel.api.model.operations.user.displayroom.UserDisplayRoomOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDisplayRoomInputConverter implements Converter<UserDisplayRoomOutput, UserDisplayRoomOutputBFF> {
    @Override
    public UserDisplayRoomOutputBFF convert(UserDisplayRoomOutput source) {
        return UserDisplayRoomOutputBFF.builder()
                .ID(source.getID())
                .price(source.getPrice())
                .datesOccupied(source.getDatesOccupied())
                .bedSize(convertBedFromHotelToBff(source.getBedSize()))
                .bathRoom(BathRoomBFF.getByCode(source.getBathRoom().toString()))
                .floor(source.getFloor())
                .build();
    }
    private List<BedBFF> convertBedFromHotelToBff(List<Bed> beds){
        return beds.stream()
                .map(b -> BedBFF.getByCode(b.toString()))
                .collect(Collectors.toList());

    }
}
