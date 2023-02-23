package com.terrifictacos.terrifictacos.web.controller;

import com.terrifictacos.terrifictacos.persistence.model.Booking;
import com.terrifictacos.terrifictacos.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        super();
        this.bookingService = bookingService;
    }

    @GetMapping(value = "/{id}")
    public Booking findBooking(@PathVariable Long id) {
        return bookingService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public void createBooking(@RequestBody Booking booking) {
        bookingService.save(booking);
    }

}
