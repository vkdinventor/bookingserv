package com.paypal.bfs.test.bookingserv.validation.helper;

import com.paypal.bfs.test.bookingserv.validation.IValidationChain;
import com.paypal.bfs.test.bookingserv.validation.ValidatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ValidationHelper<T> {

    @Autowired
    ApplicationContext applicationContext;

    public ValidatorResponse validate(String validationChain, T request) {
        return applicationContext.getBean(validationChain, IValidationChain.class).performValidation(request);
    }

}
