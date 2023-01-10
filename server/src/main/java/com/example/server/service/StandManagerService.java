package com.example.server.service;

import com.example.server.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandManagerService extends RenameMe<MessageToStandManagerService>{

    private final AirportService airportService;
    @Autowired
    public StandManagerService(AirportService airportService) {
        this.airportService = airportService;

        this.airportService.onSendMessageToStandManagerService(messageQueue::add);
    }

    public void sendMessage(MessageAssignTimeFromStandManager messageAssignTimeFromStandManagerService) {
        airportService.sendMessageFromStandManager(messageAssignTimeFromStandManagerService);
    }
    public void finished() {
        airportService.standManagerFinished();
    }

}
