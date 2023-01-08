package com.example.server.service;


import com.example.server.service.state.LandedState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

interface MessageToPilotService {}

@Service
public class PilotService {

    private final AirportService airportService;
    private final Queue<MessageToPilotService> messageToPilotServiceQueue;

    @Autowired
    public PilotService(AirportService airportService) {
        this.airportService = airportService;
        messageToPilotServiceQueue = new LinkedList<>();

        this.airportService.onSendMessageToPilotService(data -> messageToPilotServiceQueue.add(data));
    }

    public void landed() {
        airportService.pilotLanded();
    }

    public MessageToPilotService getMessage() {
        if(messageToPilotServiceQueue.isEmpty()) {
            return null;
        }

        return messageToPilotServiceQueue.poll();
    }
}
