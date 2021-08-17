package com.paypal.bfs.test.bookingserv.validation;


@FunctionalInterface
public interface IValidationChain<T> {
	ValidatorResponse performValidation(T request);
}