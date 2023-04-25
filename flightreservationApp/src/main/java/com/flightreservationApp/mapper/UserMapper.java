package com.flightreservationApp.mapper;

import com.flightreservationApp.dto.user.UserDTO;
import com.flightreservationApp.dto.user.UserUpdateDTO;
import com.flightreservationApp.entity.User;

public class UserMapper {
    public static UserDTO toDto(User u){
        return UserDTO.builder()
                .id(u.getId())
                .name(u.getName())
                .surname(u.getSurname())
                .email(u.getEmail())
                .build();

    }
    public static User toEntity(UserDTO u){
        return User.builder()
                .name(u.getName())
                .surname(u.getSurname())
                .email(u.getEmail())
                .password(u.getPassword())
                .build();
    }
    public static UserUpdateDTO toUpdateDto(User u){
        return UserUpdateDTO.builder()
                .id(u.getId())
                .name(u.getName())
                .surname(u.getSurname())
                .email(u.getEmail())
                .build();
    }
    public static User buildUpdateUser(User u, UserUpdateDTO req) {
        u.setName(req.getName());
        u.setSurname(req.getSurname());
        u.setEmail(req.getEmail());
        return u;
    }
}
