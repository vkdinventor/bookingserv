package com.paypal.bfs.test.bookingserv.repository;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepository extends CrudRepository<Booking, Integer> {
}
