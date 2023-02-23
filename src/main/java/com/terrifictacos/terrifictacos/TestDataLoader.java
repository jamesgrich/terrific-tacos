package com.terrifictacos.terrifictacos;

import com.terrifictacos.terrifictacos.persistence.model.Booking;
import com.terrifictacos.terrifictacos.persistence.repository.IBookingRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestDataLoader implements ApplicationContextAware {

    @Autowired
    private IBookingRepository bookingRepository;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setting context");
    }
}
