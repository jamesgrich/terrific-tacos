package com.terrifictacos.terrifictacos.web.controller;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.Random;

import com.terrifictacos.terrifictacos.persistence.model.Booking;
import com.terrifictacos.terrifictacos.service.BookingService;
import com.terrifictacos.terrifictacos.web.dto.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping(value = "/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        super();
        this.bookingService = bookingService;
    }

//    @GetMapping(value = "/{id}")
//    public Booking findBooking(@PathVariable Long id) {
//        return bookingService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping
//    public void createBooking(@RequestBody Booking booking) {
//        bookingService.save(booking);
//    }
//
//    @DeleteMapping
//    public void deleteBooking(@RequestBody Booking booking) { bookingService.delete(booking); }
//
//    @PutMapping
//    public void amendBooking(@RequestBody Booking booking) { bookingService.update(booking); }

    @GetMapping(value = "/new")
    public String newBooking(Model model) {
        model.addAttribute("bookings", new BookingDto());
        return "new-booking";
    }

    @PostMapping
    public String addBooking(@Valid @ModelAttribute("bookings") BookingDto booking, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-booking";
        }

        bookingService.save(convertToEntity(booking));

        return  "redirect:/bookings";
    }

    @Autowired
    public String getTodaysSpecial() {
        String specials[] = new String[] {"Taco's Supreme", "Burrito Bonzana", "Nacho Mayhem", "Jalapeno Madness"};
        Random random = new Random();
        int index = random.nextInt(specials.length);
        return specials[index];
    }

    protected Booking convertToEntity(BookingDto dto) {
        Booking booking = new Booking(dto.getName());

        return booking;
    }
}
