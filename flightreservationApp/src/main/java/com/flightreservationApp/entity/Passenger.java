package com.flightreservationApp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Passenger {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String surname;
    private boolean checkedIn;
    private Integer numberOfBags;
    @OneToOne
    private Passenger passenger;
    @OneToOne
    private Flight flight;
}
