package com.flightreservationApp.service;

import com.flightreservationApp.dto.reservation.ReservationDTO;
import com.flightreservationApp.entity.Reservation;
import org.springframework.stereotype.Service;

@Service
public interface ReservationService {
    public ReservationDTO createReservation(ReservationDTO reservationDTO);
    public Reservation getReservationById(Integer id);
    Void deleteReservationById(Integer id);
    public ReservationDTO updateReservation(Integer id ,ReservationDTO reservationDTO);
}
