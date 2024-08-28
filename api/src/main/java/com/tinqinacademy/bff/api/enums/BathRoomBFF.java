package com.tinqinacademy.bff.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum BathRoomBFF {
    PRIVATE("private"), SHARED("shared"),UNKNOWN(null);
    private final String val;
    private static final Map<String, BathRoomBFF> map= new HashMap<>();
    static {
        Arrays.stream(BathRoomBFF.values())
                .filter(b->b!=UNKNOWN)
                .forEach(bt -> map.put(bt.toString(), bt));
    }
    BathRoomBFF(String s) {
        this.val =s;
    }
    @JsonValue
    public String toString(){
        return val;
    }
    @JsonCreator
    public static BathRoomBFF getByCode(String code){
    if(map.containsKey(code)) {
        return map.get(code);
    }
    return BathRoomBFF.UNKNOWN;
    }

}
