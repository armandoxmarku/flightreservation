package com.flightreservationApp.controller;

import com.flightreservationApp.dto.reservation.ReservationDTO;
import com.flightreservationApp.entity.Reservation;
import com.flightreservationApp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private ReservationService reservationService;

    @PostMapping("/createReservation")
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO){
        ReservationDTO dto = reservationService.createReservation(reservationDTO);
        return ResponseEntity.ok(dto);
    }
    @RolesAllowed("ADMIN")
    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> reservationById(@PathVariable Integer id){
        return ResponseEntity.ok(reservationService.getReservationById(id));

    }
    @RolesAllowed("ADMIN")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteReservationbyid(@PathVariable Integer id){
        return ResponseEntity.ok(reservationService.deleteReservationById(id));
    }
    @RolesAllowed("ADMIN")
    @PutMapping("/update/{id}")
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable Integer id ,
                                                            @RequestBody ReservationDTO reservationDTO) {
        ReservationDTO dto = reservationService.updateReservation(id, reservationDTO);
        return ResponseEntity.ok(dto);
    }

}
