package service;

import model.Flight;
import storage.FlightDataBase;

import java.util.UUID;

public class FlightService {

    private final FlightDataBase flightDataBase;

    public FlightService() {
        this.flightDataBase = new FlightDataBase();
    }

    public void saveFlight(Flight flight){
        flightDataBase.save(flight);
    }

    public Flight findFlightByFlightNumber(UUID flightNumber) {
        return flightDataBase.findByNumber(flightNumber);
    }

}
