package com.example.server.service;

import com.example.server.model.MessageToService;

public class CleaningService extends MessageQueue<MessageToService> {
    private final FlightService airportService;

    public CleaningService(FlightService airportService) {
        this.airportService = airportService;

        this.airportService.onSendMessageToCleaningService(messageQueue::add);
    }
    public void finished() {
        airportService.cleaningFinished();
    }

}
