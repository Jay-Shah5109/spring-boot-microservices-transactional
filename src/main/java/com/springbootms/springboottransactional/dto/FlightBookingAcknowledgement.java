package com.springbootms.springboottransactional.dto;

import com.springbootms.springboottransactional.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingAcknowledgement {

    private String status;
    private double totalFare;
    private String pnr;
    private PassengerInfo passengerInfo;
}
