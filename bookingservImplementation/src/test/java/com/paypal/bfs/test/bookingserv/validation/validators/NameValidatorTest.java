package com.paypal.bfs.test.bookingserv.validation.validators;

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

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class NameValidatorTest {

    @InjectMocks
    private NameValidator validator;

    private Booking booking;

    @Before
    public void init() {
        booking = new Booking();
        booking.setFirstName("test");
        booking.setLastName(null);
    }

    @Test
    public void testNameValidator() {
        ValidatorResponse validatorResponse = validator.validate(booking);
        Assert.assertEquals(ValidatorResponse.ValidationStatus.SUCCESS, validatorResponse.getStatus());
    }
}