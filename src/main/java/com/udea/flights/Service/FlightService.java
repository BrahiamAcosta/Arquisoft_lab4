package com.udea.flights.Service;

import com.udea.flights.Dao.IFlightDAO;
import com.udea.flights.Exceptions.FlightNotFoundException;
import com.udea.flights.Model.Flight;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final IFlightDAO FlightDAO;

    public FlightService(IFlightDAO FlightDAO) {
        this.FlightDAO = FlightDAO;
    }

    public Flight saveFlight(Flight flight) {
        return FlightDAO.save(flight);
    }

    public String deleteFlight(Long id) {
        FlightDAO.deleteById(id);
        return "Flight removed !! ";
    }

    public Iterable<Flight> listFlights() {
        return FlightDAO.findAll();
    }

    public Optional<Flight> listFlightById(Long id) {
        return FlightDAO.findById(id);
    }

    public Flight updateFlight(Flight flight) {
        Flight existingFlight = FlightDAO.findById(flight.getIdFlight()).orElse(null);
        existingFlight.setAircraftName(flight.getAircraftName());
        existingFlight.setFlightNumber(flight.getFlightNumber());
        existingFlight.setDestination(flight.getDestination());
        existingFlight.setOrigin(flight.getOrigin());
        existingFlight.setCapacity(flight.getCapacity());
        existingFlight.setRating(flight.getRating());
        existingFlight.setFlightPlan(flight.getFlightPlan());
        existingFlight.setFlightCompleted(flight.getFlightCompleted());

        return FlightDAO.save(existingFlight);
    }

    public List<Flight> viewBestFlights() throws FlightNotFoundException {
        List<Flight> bestFlights = FlightDAO.viewBestFlights();
        if (bestFlights.isEmpty()) {
            throw new FlightNotFoundException("No flights found with rating greater than or equal to 4");
        }
        return bestFlights;
    }
}
