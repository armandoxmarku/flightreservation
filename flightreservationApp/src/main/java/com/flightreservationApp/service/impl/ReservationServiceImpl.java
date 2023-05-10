package com.flightreservationApp.service.impl;

import com.flightreservationApp.dto.passenger.PassengerDTO;
import com.flightreservationApp.dto.reservation.ReservationDTO;
import com.flightreservationApp.entity.Reservation;
import com.flightreservationApp.repository.ReservationRepository;
import com.flightreservationApp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;


    @Override
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        return null;
    }

    public Reservation getReservationById(Integer id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public void cancelReservation(ReservationDTO reservationDTO) {

    }

    @Override
    public ReservationDTO updateReservation(ReservationDTO reservationDTO, List<PassengerDTO> passengers) {
        return null;
    }

}