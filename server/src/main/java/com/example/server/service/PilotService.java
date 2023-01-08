package com.example.server.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


interface MessageToPilotService {}

@Service
public class PilotService extends RenameMe<MessageToPilotService>{

    private final AirportService airportService;

    @Autowired
    public PilotService(AirportService airportService) {
        this.airportService = airportService;

        this.airportService.onSendMessageToPilotService(messageQueue::add);
    }

    public void landed() {
        airportService.pilotLanded();
    }

}
