package com.paypal.bfs.test.bookingserv.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DatabaseException extends Exception{

    private String errorCode;
    private String errorMessage;

    public DatabaseException(){
        super();
    }

}