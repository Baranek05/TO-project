package com.example.server.service;


import com.example.server.model.MessageToService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PilotService extends RenameMe<MessageToService>{

    private final AirportService airportService;

    @Autowired
    public PilotService(AirportService airportService) {
        this.airportService = airportService;

        this.airportService.onSendMessageToPilotService(messageQueue::add);
    }

    public void landed(int flightNumber) {
        airportService.pilotLanded(flightNumber);
    }

    public void finished() {
        airportService.pilotFinished();
    }

}
