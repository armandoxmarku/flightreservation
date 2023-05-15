package com.flightreservationApp.service.impl;

import com.flightreservationApp.dto.reservation.ReservationDTO;
import com.flightreservationApp.entity.Reservation;
import com.flightreservationApp.exceptions.ResourceNotFountException;
import com.flightreservationApp.mapper.ReservationMapper;
import com.flightreservationApp.repository.ReservationRepository;
import com.flightreservationApp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;


    @Override
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        if (reservationDTO == null) {
            throw new IllegalArgumentException("ReservationDTO cannot be null");
        }
        if (reservationDTO.getDateOfDeparture() == null) {
            throw new IllegalArgumentException("Reservation dates cannot be null");
        }

        // Create new Reservation object from ReservationDTO using mapper
        Reservation reservation = ReservationMapper.toEntity(reservationDTO);

        // Persist Reservation object to database
        Reservation savedReservation = reservationRepository.save(reservation);

        // Create and return new ReservationDTO object from saved Reservation using mapper
        ReservationDTO savedReservationDTO = ReservationMapper.toDto(savedReservation);
        return savedReservationDTO;
    }

    public Reservation getReservationById(Integer id) {
        return reservationRepository.findById(id)
                .orElseThrow(()->new ResourceNotFountException(String
                        .format("reservation with id%s not found" , id)));
    }

    @Override
    public Void deleteReservationById(Integer id) {
        Reservation r = reservationRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFountException(
                        String.format("passenger with id %s not found",id)));
        reservationRepository.delete(r);

        return null;
    }

    @Override
    public ReservationDTO updateReservation(Integer id, ReservationDTO reservationDTO) {
        Reservation reservation = reservationRepository.findById(id).get();
        reservation = ReservationMapper.buildUpdateReservation(reservationDTO);
        return ReservationMapper.toUpdate(reservationRepository.save(reservation));
    }

}