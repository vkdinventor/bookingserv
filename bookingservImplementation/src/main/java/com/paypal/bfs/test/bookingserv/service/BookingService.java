package com.paypal.bfs.test.bookingserv.service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exception.DatabaseException;
import com.paypal.bfs.test.bookingserv.repository.BookingsRepository;
import com.paypal.bfs.test.bookingserv.validation.helper.ValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//defining the business logic
@Service
public class BookingService {

    @Autowired
    BookingsRepository bookingsRepository;

    @Autowired
    ValidationHelper<Booking> validationHelper;

    //getting all Booking records
    public List<Booking> getAllBooking() throws DatabaseException {
        List<Booking> Bookings = new ArrayList<Booking>();
        try {
            bookingsRepository.findAll().forEach(Bookings::add);
        } catch (Exception e) {
            //Log error
            throw new DatabaseException("4001", "Database exception");
        }
        return Bookings;
    }

    //getting a specific record
    public Booking getBookingById(int id) throws DatabaseException {
        try {
            return bookingsRepository.findById(id).get();
        } catch (Exception e) {
            //Log error
            throw new DatabaseException("4001", "Database exception");
        }
    }

    //create or update a booking
    public Booking saveOrUpdate(Booking booking) throws DatabaseException{
        Booking bookingCreated = null;
        try {
            bookingCreated = bookingsRepository.save(booking);
        } catch (Exception e) {
            //Log error
            throw new DatabaseException("4001", "Database exception");
        }
        return bookingCreated;
    }

}