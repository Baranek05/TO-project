package com.example.server.service;

import com.example.server.model.MessageFromGeneralManagerService;
import com.example.server.model.MessageToGeneralManagerService;
import com.example.server.model.MessageToStandManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class StandManagerService {

    private final AirportService airportService;

    private final Queue<MessageToStandManagerService> messageToStandManagerServiceQueue;

    @Autowired
    public StandManagerService(AirportService airportService) {
        this.airportService = airportService;
        messageToStandManagerServiceQueue = new LinkedList<>();

        this.airportService.onSendMessageToStandManagerService(messageToStandManagerServiceQueue::add);
    }

    public MessageToStandManagerService getMessage() {
        if(messageToStandManagerServiceQueue.isEmpty()) {
            return null;
        }

        return messageToStandManagerServiceQueue.poll();
    }
}
