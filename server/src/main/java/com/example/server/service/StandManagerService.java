package com.example.server.service;

import com.example.server.model.MessageAssignTimeFromStandManager;
import com.example.server.model.MessageToStandManagerService;

public class StandManagerService extends MessageQueue<MessageToStandManagerService> {
    private final FlightService flightService;

    public StandManagerService(FlightService flightService) {
        this.flightService = flightService;

        this.flightService.onSendMessageToStandManagerService(messageQueue::add);
    }

    public void sendMessage(MessageAssignTimeFromStandManager messageAssignTimeFromStandManagerService) {
        flightService.sendMessageFromStandManager(messageAssignTimeFromStandManagerService);
    }
    public void finished() {
        flightService.standManagerFinished();
    }

}