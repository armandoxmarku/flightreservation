package com.flightreservationApp.mapper;

import com.flightreservationApp.dto.passenger.PassengerDTO;
import com.flightreservationApp.entity.Passenger;

public class PassengerMapper {
    public static PassengerDTO toEntity(Passenger r){
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

}
