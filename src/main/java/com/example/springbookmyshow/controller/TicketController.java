package com.example.springbookmyshow.controller;

import com.example.springbookmyshow.dto.TicketBookingRequest;
import com.example.springbookmyshow.model.TicketBooking;
import com.example.springbookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin(
        origins = {"http://localhost:4200/"},
        methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT}
)
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket-booking")
    public ResponseEntity ticketbooking(@RequestBody TicketBookingRequest ticketBookingRequest){
        ticketService.ticketbooking(ticketBookingRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<TicketBooking> getAllOrders() {
        return ticketService.getAllBookings();
    }
}
