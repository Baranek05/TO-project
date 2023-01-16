package com.example.server.service;

import com.example.server.model.MessageToService;
import com.example.server.model.ServiceType;

public class CleaningService extends MessageQueue<MessageToService> {
    private final FlightService airportService;
    private final WorkService workService;

    public CleaningService(FlightService airportService, WorkService workService) {
        this.airportService = airportService;
        this.workService = workService;

        this.airportService.onSendMessageToCleaningService(messageQueue::add);
    }
    public void finished(int flightNumber) {
        airportService.cleaningFinished();
        workService.completeStage(flightNumber, ServiceType.CLEANING_SERVICE);
    }

}
