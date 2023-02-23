package com.terrifictacos.terrifictacos.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import com.terrifictacos.terrifictacos.persistence.model.Booking;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingRepository extends CrudRepository<Booking, Long> {

}
