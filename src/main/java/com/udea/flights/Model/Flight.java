package com.udea.flights.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idflight")
    private Long idFlight;

    @Column(name = "aircraftName",nullable = false,length = 80)
    private @NotNull String aircraftName;

    @Column(name = "flightNumber",nullable = false,length = 80)
    private @NotNull String flightNumber;

    @Column(name = "destination",nullable = false,length = 80)
    private @NotNull String destination;

    @Column(name = "origin",nullable = false,length = 80)
    private @NotNull String origin;

    @Column(name = "capacity",nullable = false,length = 80)
    private @NotNull int capacity;

    @Column(name = "rating",nullable = false,length = 80)
    @Min(value = 1, message = "Rating must be greater than or equal to 1")
    @Max(value = 5, message = "Rating must be less than or equal to 5")
    private @NotNull int rating;

    @Column(name = "flightPlan",nullable = false,length = 80)
    private @NotNull String flightPlan;

    private Boolean flightCompleted;
}
