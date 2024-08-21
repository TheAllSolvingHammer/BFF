package com.tinqinacademy.bff.domain;

import com.tinqinacademy.hotel.api.model.operations.admin.create.AdminCreateInput;
import com.tinqinacademy.hotel.api.model.operations.admin.create.AdminCreateOutput;
import com.tinqinacademy.hotel.api.model.operations.admin.delete.AdminDeleteOutput;
import com.tinqinacademy.hotel.api.model.operations.admin.partialupdate.AdminPartialUpdateInput;
import com.tinqinacademy.hotel.api.model.operations.admin.partialupdate.AdminPartialUpdateOutput;
import com.tinqinacademy.hotel.api.model.operations.admin.register.AdminRegisterOutput;
import com.tinqinacademy.hotel.api.model.operations.admin.update.AdminUpdateInput;
import com.tinqinacademy.hotel.api.model.operations.admin.update.AdminUpdateOutput;
import com.tinqinacademy.hotel.api.model.operations.user.availablecheck.UserAvailableOutput;
import com.tinqinacademy.hotel.api.model.operations.user.book.UserBookInput;
import com.tinqinacademy.hotel.api.model.operations.user.book.UserBookOutput;
import com.tinqinacademy.hotel.api.model.operations.user.displayroom.UserDisplayRoomOutput;
import com.tinqinacademy.hotel.api.model.operations.user.register.UserRegisterInput;
import com.tinqinacademy.hotel.api.model.operations.user.register.UserRegisterOutput;
import com.tinqinacademy.hotel.api.model.operations.user.unbook.UserUnbookOutput;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Override
    public UserAvailableOutput checkAvailable(LocalDate startDate, LocalDate endDate, String bed, String bathRoomType) {
        return null;
    }

    @Override
    public UserDisplayRoomOutput display(UUID roomID) {
        return null;
    }

    @Override
    public UserBookOutput book(UUID roomID, UserBookInput request) {
        return null;
    }

    @Override
    public UserUnbookOutput unbook(String reservationID) {
        return null;
    }

    @Override
    public UserRegisterOutput register(UserRegisterInput userRegisterInput) {
        return null;
    }

    @Override
    public AdminRegisterOutput adminRegister(LocalDate startDate, LocalDate endDate, String firstName, String lastname, String phoneNumber, String idNumber, LocalDate validity, String authority, LocalDate issueDate, String roomID) {
        return null;
    }

    @Override
    public AdminCreateOutput adminCreate(AdminCreateInput adminCreateInput) {
        return null;
    }

    @Override
    public AdminUpdateOutput adminUpdate(String roomID, AdminUpdateInput request) {
        return null;
    }

    @Override
    public AdminPartialUpdateOutput adminPartialUpdate(UUID roomID, AdminPartialUpdateInput request) {
        return null;
    }

    @Override
    public AdminDeleteOutput adminDelete(UUID roomID) {
        return null;
    }
}
