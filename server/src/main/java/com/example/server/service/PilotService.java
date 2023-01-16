package com.example.server.service;

import com.example.server.model.MessageToService;


public class PilotService extends MessageQueue<MessageToService> {
    private final FlightService flightService;

    public PilotService(FlightService flightService) {
        this.flightService = flightService;

        this.flightService.onSendMessageToPilotService(messageQueue::add);
    }

    public void landed(int flightNumber) {
        flightService.pilotLanded(flightNumber);
    }

    public void finished() {
        flightService.pilotFinished();
    }

}
