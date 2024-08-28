package com.tinqinacademy.bff.api.mappings;

import java.util.List;

public class MappingConstants {
    private static final String auth="/auth/";
    public static final String login=auth+"login";
    public static final String register=auth+"register";
    public static final String recover=auth+"recover-password";
    public static final String confirm=auth+"confirm-registration";
    public static final String change=auth+"change-password";
    public static final String recoverChange=auth+"recover-password-mail";
    public static final String promote=auth+"promote";
    public static final String demote=auth+"demote";
    public static final String logout=auth+"logout";
    public static final String validate=auth+"validate";
    public static final List<String> adminPaths=List.of(promote,demote);
    public static final List<String> requiredLogPaths=List.of(change,logout);


    public static final String userAvailability="hotel/available";
    public static final String userDisplay="hotel/{roomID}";
    public static final String userBook ="hotel/{roomID}";
    public static final String userUnBook ="hotel/{reservationID}";
    public static final String userRegister ="system/register";
    public static final String adminRegister ="system/register";
    public static final String adminCreate ="system/room";
    public static final String adminUpdate ="/system/room/{roomID}";
    public static final String adminPartialUpdate ="/system/room/{roomID}";
    public static final String adminDelete ="system/room/{roomID}";

}
