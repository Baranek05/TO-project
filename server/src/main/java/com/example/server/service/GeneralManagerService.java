package com.example.server.service;

import com.example.server.model.MessageToGeneralManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class GeneralManagerService {

    private final AirportService airportService;

    private final Queue<MessageToGeneralManagerService> messageToGeneralManagerServiceQueue;

    @Autowired
    public GeneralManagerService(AirportService airportService) {
        this.airportService = airportService;
        messageToGeneralManagerServiceQueue = new LinkedList<>();

        this.airportService.onSendMessageToGeneralManagerService(messageToGeneralManagerServiceQueue::add);
    }
    public void sendMessage() {
        airportService.sendMessageToStandManager();
    }
    public MessageToGeneralManagerService getMessage() {
        if(messageToGeneralManagerServiceQueue.isEmpty()) {
            return null;
        }

        return messageToGeneralManagerServiceQueue.poll();
    }
}
