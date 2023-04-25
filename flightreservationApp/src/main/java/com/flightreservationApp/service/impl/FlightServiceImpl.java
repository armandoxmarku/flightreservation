package com.flightreservationApp.service.impl;

import com.flightreservationApp.dto.flight.FlightDTO;
import com.flightreservationApp.dto.flight.FlightSearchDTO;
import com.flightreservationApp.entity.Flight;
import com.flightreservationApp.exceptions.FlightNotFound;
import com.flightreservationApp.exceptions.ResourceNotFountException;
import com.flightreservationApp.mapper.FlightMapper;
import com.flightreservationApp.repository.FlightRepository;
import com.flightreservationApp.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    @Autowired
    private  final FlightRepository flightRepository;


    @Override
    public FlightDTO addFlight(Integer id,FlightDTO flightDTO) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFountException(String
                        .format("flight with id %s not found",id)));
        return FlightMapper.toDto(flightRepository.save(FlightMapper.toEntity(flightDTO)));
    }

    @Override
    public List<FlightDTO> findFlights(FlightSearchDTO flightSearchDTO) {
        List<FlightDTO> availableFlights = new ArrayList<>();

        List<FlightDTO> allFlights = findall();

        for (FlightDTO flight : allFlights) {
            if (flight.getDepartureCity().equalsIgnoreCase(flightSearchDTO.getDepartureCity())
                    && flight.getArrivalCity().equalsIgnoreCase(flightSearchDTO.getArrivalCity())
                    && flight.getDateOfDeparture().equals(flightSearchDTO.getDepartureDate())) {
                availableFlights.add(flight);
            }
        }
        return availableFlights;
    }

    @Override
    public List<FlightDTO> findall() {
        return flightRepository.findAll()
                .stream()
                .map(FlightMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public FlightDTO getFlightById(Integer id) {
        Flight flight = flightRepository.findById(id).orElseThrow(
                () -> new FlightNotFound(
                        format("Flight with Id - %s, not found",id)));
         return null;
    }

    @Override
    public void updateFlight(Integer id, FlightDTO flightDTO) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFountException(String
                        .format("Flight with id %s not found",id)));
        FlightMapper.toDto(flightRepository.save(FlightMapper.toEntity(flightDTO)));

    }

    @Override
    public void deleteFlight(Integer id ,FlightDTO flight) {
        Flight flight1 = flightRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFountException(String
                        .format("Flight with id %s not found",id)));
                flightRepository.delete(flight1);
    }
}
