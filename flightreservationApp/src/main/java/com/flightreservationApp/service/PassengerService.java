package com.flightreservationApp.service;

import com.flightreservationApp.dto.passenger.PassengerDTO;
import com.flightreservationApp.entity.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassengerService {
    PassengerDTO registerPassenger  (PassengerDTO req );

    Passenger findById(Integer id );

    PassengerDTO updatePassenger(Integer id , PassengerDTO req);


    List<PassengerDTO> findALL ();

    Void deletePassengerById(Integer id);

}
