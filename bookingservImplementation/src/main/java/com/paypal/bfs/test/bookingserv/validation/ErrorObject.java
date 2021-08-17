package com.paypal.bfs.test.bookingserv.validation;


/*
 * Error POJO used by modules to defined specific errors.
 * These errors are later accumulated as a list in the "details" field of ErrorResponse
 */

import lombok.Data;

@Data
public class ErrorObject {

    private String errorCode;
    private String errorMessage;

    private ErrorObject(){

    }

    public static class Builder{
        private ErrorObject errorObject;

        public Builder(){
            errorObject = new ErrorObject();
        }

        public Builder buildErrorCode(String errorCode){
            errorObject.errorCode = errorCode;
            return this;
        }

        public Builder buildErrorMessage(String errorMessage){
            errorObject.errorMessage = errorMessage;
            return this;
        }

        public ErrorObject build(){
            return this.errorObject;
        }
    }

}
