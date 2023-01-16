package com.example.server.service;

import com.example.server.model.MessageAssignTimeFromStandManager;
import com.example.server.model.MessageToStandManagerService;

public class StandManagerService extends MessageQueue<MessageToStandManagerService> {
    private final FlightService flightService;
    private final WorkService workService;

    public StandManagerService(FlightService flightService, WorkService workService) {
        this.flightService = flightService;
        this.workService = workService;

        this.flightService.onSendMessageToStandManagerService(messageQueue::add);
    }

    public void sendMessage(MessageAssignTimeFromStandManager messageAssignTimeFromStandManagerService) {
        workService.createAndAssignWork(messageAssignTimeFromStandManagerService);
        flightService.sendMessageFromStandManager(messageAssignTimeFromStandManagerService);
    }
    public void finished() {
        flightService.standManagerFinished();
    }

}