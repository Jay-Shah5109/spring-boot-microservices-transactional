package com.springbootms.springboottransactional;

import com.springbootms.springboottransactional.dto.FlightBookingAcknowledgement;
import com.springbootms.springboottransactional.dto.FlightBookingRequest;
import com.springbootms.springboottransactional.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class SpringBootTransactionalApplication {

	@Autowired
	private FlightBookingService flightBookingService;

	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest flightBookingRequest) {
		return flightBookingService.bookFlightTicket(flightBookingRequest);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTransactionalApplication.class, args);
	}

}
