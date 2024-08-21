package com.tinqinacademy.bff.domain;


import com.tinqinacademy.hotel.restexport.HotelRestExport;
import jakarta.persistence.Column;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value = "hotel",url = "http://localhost:8080",configuration = ClientFactory.class)
public interface HotelService extends HotelRestExport {
}
