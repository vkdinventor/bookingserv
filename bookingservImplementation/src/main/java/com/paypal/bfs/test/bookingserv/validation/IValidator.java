package com.paypal.bfs.test.bookingserv.validation;


import org.springframework.stereotype.Component;

@Component
@FunctionalInterface
public interface IValidator<T> {
	ValidatorResponse validate(T request);
}
