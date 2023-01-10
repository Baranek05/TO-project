package com.example.server.service;

import com.example.server.model.MessageToService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LuggageService extends RenameMe<MessageToService>{


    private AirportService airportService;

    @Autowired
    public LuggageService(AirportService airportService) {
        this.airportService = airportService;

        this.airportService.onSendMessageToLuggageService(messageQueue::add);
    }

    public void finished() {
        airportService.luggageFinished();
    }

    public void finishedDeparture() {
        airportService.luggageDepartureFinished();
    }
}
