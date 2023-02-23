package com.terrifictacos.terrifictacos;

import com.terrifictacos.terrifictacos.persistence.model.Booking;
import com.terrifictacos.terrifictacos.persistence.repository.IBookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.time.LocalDate;

@SpringBootTest
public class BookingRepositoryIntegrationTest {

    @Autowired
    private IBookingRepository bookingRepository;

    @Test
    public void whenSavingBooking_thenSuccess() {

    }

}
