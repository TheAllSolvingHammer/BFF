package com.tinqinacademy.bff.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.hotel.restexport.HotelRestExport;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;

public class ClientFactory {

    @Bean
    HotelRestExport getClient(){
        final ObjectMapper objectMapper=new ObjectMapper();
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(HotelRestExport.class,"http://localhost:8080");
    }


}
