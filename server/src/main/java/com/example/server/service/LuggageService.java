package com.example.server.service;

import com.example.server.model.MessageToService;

public class LuggageService extends MessageQueue<MessageToService> {
    private FlightService flightService;

    public LuggageService(FlightService flightService) {
        this.flightService = flightService;

        this.flightService.onSendMessageToLuggageService(messageQueue::add);
    }

    public void finished() {
        flightService.luggageFinished();
    }

    public void finishedDeparture() {
        flightService.luggageDepartureFinished();
    }
}
