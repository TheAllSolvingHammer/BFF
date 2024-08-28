package com.tinqinacademy.bff.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinqinacademy.authentication.restexport.AuthenticationClient;
import com.tinqinacademy.comment.restexport.CommentClient;
import com.tinqinacademy.hotel.restexport.HotelRestExport;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientFactory {

    @Bean
    HotelRestExport getClient(){
        final ObjectMapper objectMapper=new ObjectMapper();
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(HotelRestExport.class,"http://localhost:8080");
    }
    @Bean
    AuthenticationClient getAuthClient(){
        final ObjectMapper objectMapper=new ObjectMapper();
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(AuthenticationClient.class,"http://localhost:8086");
    }

    @Bean
    CommentClient getCommentClient(){
        final ObjectMapper objectMapper=new ObjectMapper();
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(CommentClient.class,"http://localhost:8081");
    }


}
