package com.flightreservationApp.dto.passenger;

import com.flightreservationApp.entity.Flight;
import com.flightreservationApp.entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerDTO {
    private Integer id;
    private String name;
    private String surname;
    private boolean checkedIn;
    private Integer numberOfBags;
    private Passenger passenger;
    private Flight flight;
}
