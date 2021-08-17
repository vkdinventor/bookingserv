package com.paypal.bfs.test.bookingserv.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class Address {

    @Column
    @JsonProperty("line1")
    public String line1;
    @Column
    @JsonProperty("line2")
    public String line2;
    @Column
    @JsonProperty("city")
    public String city;
    @Column
    @JsonProperty("state")
    public String state;
    @Column
    @JsonProperty("zip_code")
    public String zipCode;

}
