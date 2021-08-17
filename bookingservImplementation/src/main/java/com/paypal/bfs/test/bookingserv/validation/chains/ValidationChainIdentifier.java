package com.paypal.bfs.test.bookingserv.validation.chains;

/**
 * Represents list of validation chain identifiers which are used to identify
 * validation chains for validating input.
 */
public enum ValidationChainIdentifier {


    CREATE_REQUEST_CHAIN("validateCreateBookingRequest");

    private String identifier;

    ValidationChainIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
