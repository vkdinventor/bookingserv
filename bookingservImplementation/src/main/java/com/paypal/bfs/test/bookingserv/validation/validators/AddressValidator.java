package com.paypal.bfs.test.bookingserv.validation.validators;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.validation.ErrorObject;
import com.paypal.bfs.test.bookingserv.validation.IValidator;
import com.paypal.bfs.test.bookingserv.validation.ValidatorResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressValidator implements IValidator<Booking> {

    private static final String zipCodeRegex = "\\d{6}"; //6 digit indian zip code;

    @Override
    public ValidatorResponse validate(Booking request) {
        List<ErrorObject> errors = new ArrayList<>();
        if(request.getAddress() == null){
            ErrorObject error = new ErrorObject.Builder().buildErrorCode("2000").buildErrorMessage("Address is required").build();
            errors.add(error);
            return new ValidatorResponse().setStatus(ValidatorResponse.ValidationStatus.FAILURE).setErrors(errors);
        }
        Address address = request.getAddress();
        if (StringUtils.isBlank(address.getLine1())) {
            ErrorObject error = new ErrorObject.Builder().buildErrorCode("2001").buildErrorMessage("First line of address is mandatory").build();
            errors.add(error);
        }

        if (StringUtils.isBlank(address.getCity())) {
            ErrorObject error = new ErrorObject.Builder().buildErrorCode("2002").buildErrorMessage("city of address is mandatory").build();
            errors.add(error);
        }

        if (StringUtils.isBlank(address.getState())) {
            ErrorObject error = new ErrorObject.Builder().buildErrorCode("2003").buildErrorMessage("state of address is mandatory").build();
            errors.add(error);
        }

        if (StringUtils.isBlank(address.getZipCode()) || !address.getZipCode().matches(zipCodeRegex)) {
            ErrorObject error = new ErrorObject.Builder().buildErrorCode("2004").buildErrorMessage("zip code is not valid").build();
            errors.add(error);
        }

        if (!CollectionUtils.isEmpty(errors)) {
            return new ValidatorResponse().setStatus(ValidatorResponse.ValidationStatus.FAILURE).setErrors(errors);
        }
        return (new ValidatorResponse().setStatus(ValidatorResponse.ValidationStatus.SUCCESS));
    }
}
