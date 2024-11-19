package com.udea.flights.Dao;

import com.udea.flights.Model.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlightDAO extends CrudRepository<Flight,Long> {
    @Query("SELECT f FROM Flight f WHERE f.rating>=4 AND f.flightCompleted=true")
    public List<Flight> viewBestFlights();
}
