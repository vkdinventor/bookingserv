package com.paypal.bfs.test.bookingserv.validation.validators;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.validation.ValidatorResponse;
import com.paypal.bfs.test.bookingserv.validation.utli.DateTimeFormatValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CheckInCheckOutDateTimeValidatorTest {

    @InjectMocks
    private CheckInCheckOutDateTimeValidator validator;

    @Spy
    private DateTimeFormatValidator dateTimeFormatValidator;

    private Booking booking;

    @Before
    public void init() {
        booking = new Booking();
        booking.setCheckinDatetime("2021-01-21 10:10");
        booking.setCheckoutDatetime("2021-01-22 12:10");
    }

    @Test
    public void testValidCheckInCheckoutDate() {
        ValidatorResponse validatorResponse = validator.validate(booking);
        Assert.assertEquals(ValidatorResponse.ValidationStatus.SUCCESS, validatorResponse.getStatus());
    }

    @Test
    public void testInvalidCheckInCheckoutDate() {
        booking.setCheckinDatetime("2021/01/21 12:10");
        ValidatorResponse validatorResponse = validator.validate(booking);
        Assert.assertEquals(ValidatorResponse.ValidationStatus.FAILURE, validatorResponse.getStatus());
    }
}