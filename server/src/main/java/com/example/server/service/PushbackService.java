package com.example.server.service;

import com.example.server.model.MessageToService;

public class PushbackService extends MessageQueue<MessageToService> {
    private final FlightService flightService;

    public PushbackService(FlightService flightService) {
        this.flightService = flightService;

        this.flightService.onSendMessageToPushbackService(messageQueue::add);
    }

    public void finished() {
        flightService.pushbackFinished();
    }
}
