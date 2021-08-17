package com.paypal.bfs.test.bookingserv.validation;

/**
 * Represents list of validators which are used to identify validator validating
 * input.
 * When used in Chain, make sure the concerned validator works with the supplied request.
 */
public enum ValidatorIdentifier {

	CheckInCheckOutDateTimeValidator("checkInCheckOutDateTimeValidator"),
	DateOfBirthValidator("dateOfBirthValidator"),
	NameValidator("nameValidator"),
	AddressValidator("addressValidator");

	private String identifier;

	ValidatorIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}
}
