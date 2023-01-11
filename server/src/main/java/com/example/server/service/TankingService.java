package com.example.server.service;

import com.example.server.model.MessageToService;

public class TankingService extends MessageQueue<MessageToService> {
    private final FlightService flightService;

    public TankingService(FlightService flightService) {
        this.flightService = flightService;

        this.flightService.onSendMessageToTankingService(messageQueue::add);
    }
    public void finished() {
        flightService.tankingFinished();
    }

}
