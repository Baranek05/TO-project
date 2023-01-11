package com.example.server.service;

import com.example.server.model.MessageToService;

public class BoardingService extends MessageQueue<MessageToService> {
    private final FlightService flightService;

    public BoardingService(FlightService flightService) {
        this.flightService = flightService;

        this.flightService.onSendMessageToBoardingService(messageQueue::add);
    }

    public void finished() {
        flightService.boardingFinished();
    }
    public void finishedDeparture() {
        flightService.boardingDepartureFinished();
    }


}
