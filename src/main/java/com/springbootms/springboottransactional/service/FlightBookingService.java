package com.springbootms.springboottransactional.service;

import com.springbootms.springboottransactional.dto.FlightBookingAcknowledgement;
import com.springbootms.springboottransactional.dto.FlightBookingRequest;
import com.springbootms.springboottransactional.entity.PassengerInfo;
import com.springbootms.springboottransactional.entity.PaymentInfo;
import com.springbootms.springboottransactional.repo.PassengerInfoRepository;
import com.springbootms.springboottransactional.repo.PaymentInfoRepository;
import com.springbootms.springboottransactional.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;


    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest
                                                                 flightBookingRequest) {

        PassengerInfo passengerInfo = flightBookingRequest.getPassengerInfo();
        passengerInfoRepository.save(passengerInfo);
        PaymentInfo paymentInfo = flightBookingRequest.getPaymentInfo();
        //  credit limit validation - by calling PaymentUtils utility class
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNumber(), passengerInfo.getFare());

        paymentInfo.setPassengerID(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());

        paymentInfoRepository.save(paymentInfo);

        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(),
                UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }
}
