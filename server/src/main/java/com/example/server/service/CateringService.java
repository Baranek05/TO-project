package com.example.server.service;

import com.example.server.model.MessageToService;

public class CateringService extends MessageQueue<MessageToService> {
    private final FlightService flightService;

    public CateringService(FlightService flightService) {
        this.flightService = flightService;

        this.flightService.onSendMessageToCateringService(messageQueue::add);
    }

    public void finished() {
        flightService.cateringFinished();
    }
}
