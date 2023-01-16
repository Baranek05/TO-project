package com.example.server.service;

import com.example.server.model.MessageToService;
import com.example.server.model.ServiceType;

public class LuggageService extends MessageQueue<MessageToService> {
    private final FlightService flightService;
    private final WorkService workService;

    public LuggageService(FlightService flightService, WorkService workService) {
        this.flightService = flightService;
        this.workService = workService;

        this.flightService.onSendMessageToLuggageService(messageQueue::add);
    }

    public void finished(int flightNumber) {
        flightService.luggageFinished();
        workService.completeStage(flightNumber, ServiceType.LUGGAGE_SERVICE);
    }

    public void finishedDeparture() {
        flightService.luggageDepartureFinished();
    }
}
