package com.example.server.service;

import com.example.server.model.MessageFromGeneralManagerService;
import com.example.server.model.MessageToGeneralManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GeneralManagerService extends RenameMe<MessageToGeneralManagerService> {

    private final AirportService airportService;

    @Autowired
    public GeneralManagerService(AirportService airportService) {
        this.airportService = airportService;

        this.airportService.onSendMessageToGeneralManagerService(messageQueue::add);
    }

    public void sendMessage(MessageFromGeneralManagerService messageFromGeneralManagerService) {
        airportService.sendMessageFromGeneralManager(messageFromGeneralManagerService);
    }

}
