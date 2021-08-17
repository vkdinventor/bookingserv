package com.paypal.bfs.test.bookingserv.validation.chains;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.validation.AbstractValidationChain;
import com.paypal.bfs.test.bookingserv.validation.ValidatorIdentifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ValidateCreateBookingRequest extends AbstractValidationChain<Booking> {

    public ValidateCreateBookingRequest() {
        listOfValidations = populateValidations();
    }

    private List<String> populateValidations() {
        return Arrays.asList(
                ValidatorIdentifier.NameValidator.getIdentifier(),
                ValidatorIdentifier.CheckInCheckOutDateTimeValidator.getIdentifier(),
                ValidatorIdentifier.DateOfBirthValidator.getIdentifier(),
                ValidatorIdentifier.AddressValidator.getIdentifier());
    }

}
