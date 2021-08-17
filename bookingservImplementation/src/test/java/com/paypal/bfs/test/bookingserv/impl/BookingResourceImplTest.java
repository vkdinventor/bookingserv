package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exception.DatabaseException;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import com.paypal.bfs.test.bookingserv.validation.ValidatorResponse;
import com.paypal.bfs.test.bookingserv.validation.helper.ValidationHelper;
import com.paypal.bfs.test.bookingserv.validation.utli.DateTimeFormatValidator;
import com.paypal.bfs.test.bookingserv.validation.validators.CheckInCheckOutDateTimeValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.AssertTrue;
import java.util.Arrays;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class BookingResourceImplTest {

    @InjectMocks
    private BookingResourceImpl resource;

    @Mock
    private BookingService service;

    @Mock
    private ValidationHelper<Booking> validationHelper;

    private Booking booking;

    @Before
    public void init() {
        booking = new Booking();
        booking.setId(1);
        booking.setCheckinDatetime("2021-01-21 10:10");
        booking.setCheckoutDatetime("2021-01-22 12:10");
        booking.setDateOfBirth("1993-01-25");
        booking.setFirstName("test");
        Address address = new Address();
        address.setLine1("adgadgd");
        address.setCity("New Delhi");
        address.setState("Delhi");
        address.setZipCode("232103");
        booking.setAddress(address);
        ValidatorResponse validatorResponse = new ValidatorResponse();
        validatorResponse.setStatus(ValidatorResponse.ValidationStatus.SUCCESS);
        Mockito.when(validationHelper.validate(Mockito.any(), Mockito.any())).thenReturn(validatorResponse);
    }


    @Test
    public void create() throws DatabaseException {
        Mockito.when(service.saveOrUpdate(Mockito.any())).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                return invocationOnMock.getArgument(0);
            }
        });
        ResponseEntity<Object> response  = resource.create(booking);
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assert.assertEquals(booking, (Booking) response.getBody());
    }

    @Test
    public void getBookings() throws DatabaseException{
        Mockito.when(service.getAllBooking()).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                return Arrays.asList(booking, booking);
            }
        });
        ResponseEntity<Object> response  = resource.getBookings();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(2, ((List<Booking>) response.getBody()).size());
    }

    @Test
    public void getBookingById() throws Exception{
        Mockito.when(service.getBookingById(1)).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                return booking;
            }
        });
        ResponseEntity<Object> response  = resource.getBookingById(1);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertTrue(response.getBody() != null);
    }
}