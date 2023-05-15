package com.flightreservationApp.controller;

import com.flightreservationApp.dto.passenger.PassengerDTO;
import com.flightreservationApp.entity.Passenger;
import com.flightreservationApp.mapper.PassengerMapper;
import com.flightreservationApp.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/passenger")
public class PassengerController {
    private final PassengerService passengerService;

    @PostMapping("/register")
    public ResponseEntity<PassengerDTO>registerPassenger(@RequestBody PassengerDTO passengerDTO){
        PassengerDTO dto = passengerService.registerPassenger(passengerDTO);
        return ResponseEntity.ok(dto);
    }
    @RolesAllowed("ADMIN")
    @GetMapping("/admin/{id}")
    public  ResponseEntity<PassengerDTO>findById (@PathVariable Integer id){
        Passenger p = passengerService.findById(id);
        return ResponseEntity.ok(PassengerMapper.toDTO(p));

    }
    @RolesAllowed("ADMIN")
    @PutMapping("/admin/{id}")
    public ResponseEntity<PassengerDTO> updatePassenger(@PathVariable Integer id, @RequestBody PassengerDTO passengerDTO){
        PassengerDTO dto = passengerService.updatePassenger(id,passengerDTO);
        return ResponseEntity.ok(dto);
    }
    @RolesAllowed("ADMIN")
    @GetMapping("/findAll")
    public ResponseEntity <List<PassengerDTO>> findALL (){
        return ResponseEntity.ok(passengerService.findALL());
    }
    @RolesAllowed("ADMIN")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePassengerById(@PathVariable Integer id){
        return  ResponseEntity.ok(passengerService.deletePassengerById(id));
    }
}
