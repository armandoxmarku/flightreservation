package com.flightreservationApp.dto.flight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightSearchDTO {
    private String departureCity;
    private String arrivalCity;
    private Date departureDate;
}
