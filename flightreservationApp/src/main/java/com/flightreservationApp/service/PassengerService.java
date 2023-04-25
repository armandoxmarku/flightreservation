package com.flightreservationApp.service;

import com.flightreservationApp.dto.passenger.PassengerDTO;
import org.springframework.stereotype.Service;

@Service
public interface PassengerService {
    public PassengerDTO createPassenger(String name, String email);
    public PassengerDTO getPassengerById(Integer id);

}
