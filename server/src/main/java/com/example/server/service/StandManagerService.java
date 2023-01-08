package com.example.server.service;

import com.example.server.model.MessageFromGeneralManagerService;
import com.example.server.model.MessageFromStandManagerService;
import com.example.server.model.MessageToStandManagerService;
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

    public void sendMessage(MessageFromStandManagerService messageFromStandManagerService) {
        airportService.sendMessageFromStandManager(messageFromStandManagerService);
    }

}
