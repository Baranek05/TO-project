package com.example.server.service;

import com.example.server.model.MessageToService;
import com.example.server.model.ServiceType;

public class TankingService extends MessageQueue<MessageToService> {
    private final FlightService flightService;
    private final WorkService workService;

    public TankingService(FlightService flightService, WorkService workService) {
        this.flightService = flightService;
        this.workService = workService;

        this.flightService.onSendMessageToTankingService(messageQueue::add);
    }
    public void finished(int flightNumber) {
        flightService.tankingFinished();
        workService.completeStage(flightNumber, ServiceType.TANKING_SERVICE);
    }

}
