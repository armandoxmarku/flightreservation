package com.flightreservationApp.service;

import com.flightreservationApp.dto.passenger.PassengerDTO;
import com.flightreservationApp.dto.reservation.ReservationDTO;
import com.flightreservationApp.dto.flight.FlightDTO;
import com.flightreservationApp.dto.user.UserDTO;
import com.flightreservationApp.entity.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReservationService {
    public ReservationDTO createReservation(UserDTO userDTO, FlightDTO flight, List<PassengerDTO> passengers);
    public Reservation getReservationById(Integer id);
    public void cancelReservation(ReservationDTO reservationDTO);
    public ReservationDTO updateReservation(ReservationDTO reservationDTO, List<PassengerDTO> passengers);
}
