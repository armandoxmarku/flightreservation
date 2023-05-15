package com.flightreservationApp.controller;

import com.flightreservationApp.dto.flight.FlightDTO;
import com.flightreservationApp.dto.flight.FlightSearchDTO;
import com.flightreservationApp.entity.User;
import com.flightreservationApp.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    @RolesAllowed("ADMIN")
    @PostMapping("/addflights/{id}")
    public ResponseEntity<FlightDTO> addFlight(@PathVariable Integer id, @RequestBody FlightDTO flightDTO) {
        return ResponseEntity.ok(flightService.addFlight(id, flightDTO));
    }

    @GetMapping("/findFlights")
    public ResponseEntity <List<FlightDTO>>findFlights(@RequestBody FlightSearchDTO flightSearchDTO){
        return ResponseEntity.ok(flightService.findFlights(flightSearchDTO));
    }
    @GetMapping("/flightslist")
    public ResponseEntity<List<FlightDTO>> findall(){
        return ResponseEntity.ok(flightService.findall());

    }
    @GetMapping("/flight/{flightId}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable Integer id){
        return ResponseEntity.ok(flightService.getFlightById(id));
    }




}
