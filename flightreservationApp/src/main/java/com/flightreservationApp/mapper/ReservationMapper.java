package com.flightreservationApp.mapper;

import com.flightreservationApp.dto.reservation.ReservationDTO;
import com.flightreservationApp.entity.Reservation;

public class ReservationMapper {
    public static ReservationDTO toDto(Reservation p){
        return ReservationDTO.builder()
                .id(p.getId())
                .departureCity(p.getDepartureCity())
                .arrivalCity(p.getArrivalCity())
                .flightNumber(p.getFlightNumber())
                .dateOfDeparture(p.getDateOfDeparture())
                .estimatedDepartureTime(p.getEstimatedDepartureTime())
                .operatingAirlines(p.getOperatingAirlines())
                .build();
    }
    public static Reservation toEntity(ReservationDTO p) {
        return Reservation.builder()
                .id(p.getId())
                .departureCity(p.getDepartureCity())
                .arrivalCity(p.getArrivalCity())
                .flightNumber(p.getFlightNumber())
                .dateOfDeparture(p.getDateOfDeparture())
                .estimatedDepartureTime(p.getEstimatedDepartureTime())
                .operatingAirlines(p.getOperatingAirlines())
                .build();
    }
}
