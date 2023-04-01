package com.terrifictacos.terrifictacos.web.controller;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import com.terrifictacos.terrifictacos.persistence.model.Booking;
import com.terrifictacos.terrifictacos.service.BookingService;
import com.terrifictacos.terrifictacos.web.dto.BookingDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        super();
        this.bookingService = bookingService;
    }

    @GetMapping
    public String getBookings(Model model) {
        Iterable<Booking> bookings = bookingService.findAll();
        List<BookingDto> bookingDtos = new ArrayList<>();
        bookings.forEach(b -> bookingDtos.add(convertToDto(b)));
        model.addAttribute("bookings", bookingDtos);
        return "bookings";
    }

    @GetMapping(value = "/new")
    public String newBooking(Model model) {
        model.addAttribute("bookings", new BookingDto());
        return "new-booking";
    }

    @PostMapping(value= "/addbooking")
    public String addBooking(@Valid @ModelAttribute("bookings") BookingDto booking, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-booking";
        }

        bookingService.save(convertToEntity(booking));
        return "redirect:/bookings";
    }

    @GetMapping(value = "/edit/{id}")
    public String editSingleBooking(@PathVariable Long id, Model model) {
        Booking booking = bookingService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid booking ID: " + id));
        model.addAttribute("booking", convertToDto(booking));
        return "edit-booking";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateBooking(@Valid @ModelAttribute("bookings") BookingDto booking, BindingResult result) {
        if (result.hasErrors()) {
            return "new-booking";
        }

        bookingService.save(convertToEntity(booking));
        return "redirect:/bookings";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        Booking booking = bookingService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid booking ID: " + id));
        bookingService.delete(booking);
        return "redirect:/bookings";
    }

    private BookingDto convertToDto(Booking entity) {
        BookingDto dto = new BookingDto(entity.getId(), entity.getName(), entity.getDate(), entity.getGuests());
        return dto;
    }

    protected Booking convertToEntity(BookingDto dto) {
        Booking booking = new Booking(dto.getId(), dto.getName(), dto.getDate(), dto.getGuests());
        return booking;
    }
}
