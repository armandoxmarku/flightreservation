package com.flightreservationApp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Flight {
    @Id
    @GeneratedValue
    private Integer id;
    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    private Date dateOfDeparture;
    private Timestamp estimatedDepartureTime;

    public Flight(Integer flightNumber, String departureCity, String arrivalCity, String departureCity1, Date dateOfDeparture, Date estimatedDepartureTime) {
    }
}
