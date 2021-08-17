package com.paypal.bfs.test.bookingserv.api.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Table
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JsonProperty("id")
    public Integer id;

    @Column
    @JsonProperty("first_name")
    public String firstName;

    @Column
    @JsonProperty("last_name")
    public String lastName;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column
    @JsonProperty("date_of_birth")
    public String dateOfBirth;


    @NotNull
    @DateTimeFormat(pattern="yyyyMMdd hh:mm:ss")
    @Column
    @JsonProperty("checkin_datetime")
    public String checkinDatetime;

    @NotNull
    @DateTimeFormat(pattern="yyyyMMdd hh:mm:ss")
    @Column
    @JsonProperty("checkout_datetime")
    public String checkoutDatetime;

    @Column
    @JsonProperty("total_price")
    public Integer totalPrice;

    @Column
    @JsonProperty("deposit")
    public Integer deposit;

    @Embedded
    public Address address;
}
