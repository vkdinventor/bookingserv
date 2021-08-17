package com.paypal.bfs.test.bookingserv.api;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

public interface BookingResource {
    /**
     * Create {@link Booking} resource
     *
     * @param booking the booking object
     * @return the created booking
     */
    @RequestMapping(value = "/v1/bfs/booking", method = RequestMethod.POST)
    ResponseEntity<Object> create(@RequestBody Booking booking);

    // ----------------------------------------------------------
    // TODO - add a new operation for Get All the bookings resource.
    // ----------------------------------------------------------

    @RequestMapping(value = "/v1/bfs/bookings", method = RequestMethod.GET)
    ResponseEntity<Object> getBookings();

    @RequestMapping(value = "/v1/bfs/bookings/{id}", method = RequestMethod.GET)
    ResponseEntity<Object> getBookingById(@PathVariable("id") Integer id);
}
