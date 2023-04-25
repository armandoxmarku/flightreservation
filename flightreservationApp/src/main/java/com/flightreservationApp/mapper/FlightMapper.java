package com.flightreservationApp.mapper;

import com.flightreservationApp.dto.flight.FlightDTO;
import com.flightreservationApp.dto.flight.FlightSearchDTO;
import com.flightreservationApp.entity.Flight;

public class FlightMapper {
    public static FlightDTO toDto(Flight f){
        return FlightDTO.builder()
                .id(f.getId())
                .flightNumber(f.getFlightNumber())
                .departureCity(f.getDepartureCity())
                .arrivalCity(f.getArrivalCity())
                .dateOfDeparture(f.getDateOfDeparture())
                .estimatedDepartureTime(f.getEstimatedDepartureTime())
                .operatingAirlines(f.getOperatingAirlines())
                .build();
    }
    public static Flight toEntity(FlightDTO f){
        return Flight.builder()
                .id(f.getId())
                .flightNumber(f.getFlightNumber())
                .departureCity(f.getDepartureCity())
                .arrivalCity(f.getArrivalCity())
                .dateOfDeparture(f.getDateOfDeparture())
                .estimatedDepartureTime(f.getEstimatedDepartureTime())
                .operatingAirlines(f.getOperatingAirlines())
                .build();
    }
    public static FlightSearchDTO toFlightSearchdto(FlightSearchDTO f){
        return FlightSearchDTO.builder()
                .departureCity(f.getDepartureCity())
                .arrivalCity(f.getArrivalCity())
                .departureDate(f.getDepartureDate())
                .build();

    }



}
