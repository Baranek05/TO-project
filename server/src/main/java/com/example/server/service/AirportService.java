package com.example.server.service;

import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AirportService {
    private final Map<UUID, Services> stateByFlightNumber;

    public AirportService() {
        stateByFlightNumber = new HashMap<>();
    }

    private Services services() {
        var flightService = new FlightService();

        return new Services(
                flightService,
                new BoardingService(flightService),
                new CateringService(flightService),
                new CleaningService(flightService),
                new GeneralManagerService(flightService),
                new LuggageService(flightService),
                new PilotService(flightService),
                new PushbackService(flightService),
                new StandManagerService(flightService),
                new TankingService(flightService)
        );
    }

    public Services getMessage(UUID flightNumber) {
        if(!stateByFlightNumber.containsKey(flightNumber))
            stateByFlightNumber.put(flightNumber, services());

        return stateByFlightNumber.get(flightNumber);
    }
}
