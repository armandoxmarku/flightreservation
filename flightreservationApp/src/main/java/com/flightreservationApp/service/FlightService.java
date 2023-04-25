package com.flightreservationApp.service;

import com.flightreservationApp.dto.flight.FlightDTO;
import com.flightreservationApp.dto.flight.FlightSearchDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface FlightService {
    public FlightDTO addFlight(Integer id ,FlightDTO flightDTO);
    public List<FlightDTO> findFlights(FlightSearchDTO flightSearchDTO);
    List<FlightDTO> findall();

    public FlightDTO getFlightById(Integer id);
    public void updateFlight(Integer id,FlightDTO flight);
    public void deleteFlight(Integer id,FlightDTO flight);
}
