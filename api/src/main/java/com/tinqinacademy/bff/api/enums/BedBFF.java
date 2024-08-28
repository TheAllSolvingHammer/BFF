package com.tinqinacademy.bff.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum BedBFF {
    SINGLE("single"),
    DOUBLE("double"),
    SMALLDOUBLE("smallDouble"),
    KINGSIZE("kingSize"),
    QUEENSIZE("queenSize"),
    @JsonIgnore
    UNKNOWN(null);
    private final String val;

    private static final Map<String, BedBFF> map = new HashMap<>();

    static {
        Arrays.stream(BedBFF.values())
                .filter(b -> b != UNKNOWN)
                .forEach(b -> map.put(b.val, b));
    }

    BedBFF(String name) {
        this.val = name;
    }

    @JsonValue
    public String toString() {
        return val;
    }

    @JsonCreator
    public static BedBFF getByCode(String code) {
        if (map.containsKey(code)) {
            return map.get(code);
        }
        return BedBFF.UNKNOWN;
    }
}
