package com.udea.flights.Controller;

import com.udea.flights.Exceptions.InvalidRating;
import com.udea.flights.Exceptions.ModelNotFoundException;
import com.udea.flights.Model.Flight;
import com.udea.flights.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
@CrossOrigin("*")

public class FlightController {
    @Autowired
    FlightService flightService;
    @PostMapping("/save")
    public long save(
            @RequestBody Flight flight) throws InvalidRating {
        if(flight.getRating() > 5)
            throw new InvalidRating("Id should be less than or equal 5");
        flightService.saveFlight(flight);
        return flight.getIdFlight();
    }
    @GetMapping("/listAll")
    public Iterable<Flight> listAllFlights(){return flightService.listFlights();}
    @GetMapping("/list/{id}")
    public Flight listFlightById( @PathVariable("id") Long id){
        Optional<Flight> flight= flightService.listFlightById(id);
        if(flight.isPresent()){
            return flight.get();
        }
        throw new ModelNotFoundException("ID de Flight invalido");
    }
    @GetMapping("/topFlights")
    public ResponseEntity<List<Flight>> viewBestFlights(){
        List<Flight> list=flightService.viewBestFlights();
        return new ResponseEntity<List<Flight>>(list, HttpStatus.ACCEPTED);
    }
    @PutMapping
    public Flight updateFlight(@RequestBody Flight flight){
        return flightService.updateFlight(flight);
    }
    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable long id){
        return flightService.deleteFlight(id);
    }
}
