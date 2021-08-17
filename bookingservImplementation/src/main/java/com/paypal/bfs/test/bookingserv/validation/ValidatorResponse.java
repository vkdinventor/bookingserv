package com.paypal.bfs.test.bookingserv.validation;


import java.util.List;

public class ValidatorResponse {

	private ValidationStatus status;
	private String failureMessage;
	private List<ErrorObject> errors;

	public enum ValidationStatus {
		SUCCESS,
		FAILURE
    }

	public ValidationStatus getStatus() {
		return status;
	}

	public ValidatorResponse setStatus(ValidationStatus status) {
		this.status = status;
		return this;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public ValidatorResponse setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
		return this;
	}
	public List<ErrorObject> getErrors() {
		return errors;
	}

	public ValidatorResponse setErrors(List<ErrorObject> errors) {
		this.errors = errors;
		return this;
	}
}