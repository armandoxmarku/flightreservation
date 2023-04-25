package com.flightreservationApp.service.impl;

import com.flightreservationApp.dto.reservation.ReservationDTO;
import com.flightreservationApp.entity.Flight;
import com.flightreservationApp.entity.Passenger;
import com.flightreservationApp.entity.Reservation;
import com.flightreservationApp.entity.User;
import com.flightreservationApp.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl {
    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationDTO createReservation(User user, Flight flight, List<Passenger> passengers) {
        return null;
    }

    public Reservation getReservationById(Integer id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public void cancelReservation(Reservation reservation) {
        reservationRepository.delete(reservation);

    }

    public Reservation updateReservation(Reservation reservation, List<Passenger> passenger) {

        return null;
    }
}