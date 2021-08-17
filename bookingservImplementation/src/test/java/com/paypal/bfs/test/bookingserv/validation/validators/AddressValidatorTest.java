package com.paypal.bfs.test.bookingserv.validation.validators;


import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.validation.ValidatorResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddressValidatorTest {

    @InjectMocks
    private AddressValidator addressValidator;

    private Booking booking;

    @Before
    public void init(){
        booking = new Booking();
        Address address = new Address();
        address.setLine1("adgadgd");
        address.setCity("New Delhi");
        address.setState("Delhi");
        address.setZipCode("232103");
        booking.setAddress(address);
    }

    @Test
    public void testAddress(){
        booking.getAddress().setLine1("first address line");
        ValidatorResponse validatorResponse = addressValidator.validate(booking);
        Assert.assertEquals(ValidatorResponse.ValidationStatus.SUCCESS ,validatorResponse.getStatus());

        booking.getAddress().setLine1(null);
        validatorResponse = addressValidator.validate(booking);
        Assert.assertEquals(ValidatorResponse.ValidationStatus.FAILURE ,validatorResponse.getStatus());
    }

}