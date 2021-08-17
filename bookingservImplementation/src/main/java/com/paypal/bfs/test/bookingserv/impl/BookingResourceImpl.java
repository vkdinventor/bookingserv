package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exception.DatabaseException;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import com.paypal.bfs.test.bookingserv.validation.ErrorObject;
import com.paypal.bfs.test.bookingserv.validation.chains.ValidationChainIdentifier;
import com.paypal.bfs.test.bookingserv.validation.ValidatorResponse;
import com.paypal.bfs.test.bookingserv.validation.helper.ValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookingResourceImpl implements BookingResource {

    private static Map<Integer, Booking> map = new HashMap<>();

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ValidationHelper<Booking> validationHelper;


    @Override
    public ResponseEntity<Object> create(Booking booking) {
        ValidatorResponse validatorResponse = validationHelper.validate(ValidationChainIdentifier.CREATE_REQUEST_CHAIN.getIdentifier(),booking);
        if (validatorResponse.getStatus() != ValidatorResponse.ValidationStatus.SUCCESS) {
            return new ResponseEntity<>(validatorResponse.getErrors(), HttpStatus.BAD_REQUEST);
        }
        Booking newBooking = null;
        try {
            newBooking = bookingService.saveOrUpdate(booking);
        } catch (DatabaseException e) {
            ErrorObject errorObject = new ErrorObject.Builder().buildErrorCode(e.getErrorCode()).buildErrorMessage(e.getErrorMessage()).build();
            return new ResponseEntity<>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getBookings() {
        List<Booking> bookings = null;
        try {
            bookings = bookingService.getAllBooking();
        } catch (DatabaseException e) {
            ErrorObject errorObject = new ErrorObject.Builder().buildErrorCode(e.getErrorCode()).buildErrorMessage(e.getErrorMessage()).build();
            return new ResponseEntity<>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getBookingById(Integer id) {
        Booking booking = null;
        try {
            booking = bookingService.getBookingById(id);
        } catch (DatabaseException e) {
            ErrorObject errorObject = new ErrorObject.Builder().buildErrorCode(e.getErrorCode()).buildErrorMessage(e.getErrorMessage()).build();
            return new ResponseEntity<>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
}
