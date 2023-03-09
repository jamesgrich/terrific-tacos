package com.terrifictacos.terrifictacos;

import com.terrifictacos.terrifictacos.persistence.model.Booking;
import com.terrifictacos.terrifictacos.persistence.repository.IBookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class BookingRepositoryIntegrationTest {

    @Autowired
    private IBookingRepository bookingRepository;

    @Test
    public void givenBookingSaved_ThenSuccess() {
        //Booking booking = new Booking(1l, "Booking Test Name");
        //assertNotNull(bookingRepository.save(booking));
    }

//    @Test
//    public void givenBookingCreated_thenFindByIdSuccess() {
//        Booking newBooking = new Booking(1l, "Booking Test Name");
//        bookingRepository.save(newBooking);
//
//        Optional<Booking> retrievedBooking = bookingRepository.findById(newBooking.getId());
//        assertEquals(retrievedBooking.get(), newBooking);
//    }

}
