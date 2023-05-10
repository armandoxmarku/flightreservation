package com.flightreservationApp.mapper;

import com.flightreservationApp.dto.passenger.PassengerDTO;
import com.flightreservationApp.entity.Passenger;

public class PassengerMapper {
    public static PassengerDTO toDTO(Passenger r){
        return PassengerDTO.builder()
                .id(r.getId())
                .passenger(r.getPassenger())
                .flight(r.getFlight())
                .checkedIn(r.isCheckedIn())
                .numberOfBags(r.getNumberOfBags())
                .build();
    }
    public static Passenger toEntity(PassengerDTO r) {
        return Passenger.builder()
                .id(r.getId())
                .passenger(r.getPassenger())
                .flight(r.getFlight())
                .checkedIn(r.isCheckedIn())
                .numberOfBags(r.getNumberOfBags())
                .build();

    }
    public static PassengerDTO toUpdateDto(Passenger p){
        return PassengerDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .surname(p.getSurname())
                .build();
    }
    public static Passenger buildUpdatePassenger(Passenger p , PassengerDTO req){
        return Passenger.builder()
                .id(p.getId())
                .name(p.getName())
                .surname(p.getSurname())
                .build();
    }
}
