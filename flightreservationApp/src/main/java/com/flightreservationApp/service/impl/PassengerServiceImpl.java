package com.flightreservationApp.service.impl;

import com.flightreservationApp.dto.passenger.PassengerDTO;
import com.flightreservationApp.entity.Passenger;
import com.flightreservationApp.exceptions.ResourceNotFountException;
import com.flightreservationApp.mapper.PassengerMapper;
import com.flightreservationApp.repository.PassengerRepository;
import com.flightreservationApp.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private PassengerRepository passengerRepository;


    @Override
    public PassengerDTO registerPassenger(PassengerDTO req) {
        Passenger p = PassengerMapper.toEntity(req);
        if (p.getId()==null)
            p = passengerRepository.save(p);
        return PassengerMapper.toDTO(p);
    }

    @Override
    public Passenger findById(Integer id) {
        return passengerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFountException(String
                        .format("passenger with id%s not found" , id)));
    }

    @Override
    public PassengerDTO updatePassenger(Integer id, PassengerDTO req) {
        Passenger passenger = findById(id);
        passenger = PassengerMapper.buildUpdatePassenger(passenger, req );
        return PassengerMapper.toUpdateDto(passengerRepository.save(passenger));
    }

    @Override
    public List<PassengerDTO> findALL() {
        return passengerRepository.findAll()
                .stream()
                .map(PassengerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Void deletePassengerById(Integer id) {
        Passenger p = passengerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFountException(
                        String.format("passenger with id %s not found",id)));
        passengerRepository.delete(p);
        return null;
    }

}
