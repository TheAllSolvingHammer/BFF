package com.tinqinacademy.bff.rest.controllers;

import ch.qos.logback.core.sift.AppenderTracker;
import com.tinqinacademy.bff.domain.HotelService;
import com.tinqinacademy.hotel.api.model.operations.admin.create.AdminCreateInput;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller extends BaseController{
    private final HotelService service;

    public void test(@RequestBody AdminCreateInput input){
        service.adminCreate(input);
    }
}
