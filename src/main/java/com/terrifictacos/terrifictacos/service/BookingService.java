package com.terrifictacos.terrifictacos.service;

import com.terrifictacos.terrifictacos.persistence.model.Booking;

import java.awt.print.Book;
import java.util.Optional;

public interface BookingService {

    Optional<Booking> findById(Long id);

    Booking save (Booking booking);

    Iterable<Booking> findAll();

    void delete (Booking booking);

    Booking update (Booking booking);

}
