package com.example.server.service;

import com.example.server.model.MessageFromGeneralManagerService;
import com.example.server.model.MessageToGeneralManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class GeneralManagerService extends MessageQueue<MessageToGeneralManagerService> {

    private FlightService flightService;


    public GeneralManagerService(FlightService flightService) {
        this.flightService = flightService;

        this.flightService.onSendMessageToGeneralManagerService(messageQueue::add);
    }
    public void sendMessage(MessageFromGeneralManagerService messageFromGeneralManagerService) {
        flightService.sendMessageFromGeneralManager(messageFromGeneralManagerService);
    }

}
