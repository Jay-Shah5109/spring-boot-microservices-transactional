package com.springbootms.springboottransactional.dto;

import com.springbootms.springboottransactional.entity.PassengerInfo;
import com.springbootms.springboottransactional.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
