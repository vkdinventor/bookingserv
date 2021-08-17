package com.paypal.bfs.test.bookingserv.validation.validators;

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
public class NameValidator implements IValidator<Booking> {

    @Override
    public ValidatorResponse validate(Booking request) {
        List<ErrorObject> errors = new ArrayList<>();
        if (StringUtils.isBlank(request.getFirstName())) {
            ErrorObject error = new ErrorObject.Builder().buildErrorCode("4001").buildErrorMessage("first name is required").build();
            errors.add(error);
        }

        if (!CollectionUtils.isEmpty(errors)) {
            return new ValidatorResponse().setStatus(ValidatorResponse.ValidationStatus.FAILURE).setErrors(errors);
        }
        return (new ValidatorResponse().setStatus(ValidatorResponse.ValidationStatus.SUCCESS));

    }
}
