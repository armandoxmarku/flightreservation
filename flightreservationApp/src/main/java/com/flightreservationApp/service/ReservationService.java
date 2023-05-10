package com.flightreservationApp.service;

import com.flightreservationApp.dto.passenger.PassengerDTO;
import com.flightreservationApp.dto.reservation.ReservationDTO;
import com.flightreservationApp.entity.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReservationService {
    public ReservationDTO createReservation(ReservationDTO reservationDTO);
    public Reservation getReservationById(Integer id);
    public void cancelReservation(ReservationDTO reservationDTO);
    public ReservationDTO updateReservation(ReservationDTO reservationDTO, List<PassengerDTO> passengers);
}
