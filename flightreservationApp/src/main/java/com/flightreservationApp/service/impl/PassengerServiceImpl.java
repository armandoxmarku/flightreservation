package com.flightreservationApp.service.impl;

import com.flightreservationApp.dto.passenger.PassengerDTO;
import com.flightreservationApp.repository.PassengerRepository;
import com.flightreservationApp.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private PassengerRepository passengerRepository;

    public PassengerDTO createPassenger(String name, String email) {
        return null;
    }

    public PassengerDTO getPassengerById(Integer id) {
         passengerRepository.findById(id).orElse(null);
         return  null;
    }
}
