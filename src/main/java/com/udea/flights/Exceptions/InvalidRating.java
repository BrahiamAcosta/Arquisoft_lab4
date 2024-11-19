package com.udea.flights.Exceptions;

public class InvalidRating extends RuntimeException {

    public InvalidRating() {
        super();
    }

    public InvalidRating(String message) {
        super(message);
    }
}
