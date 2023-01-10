package com.example.server.service;

import com.example.server.model.MessageToService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PushbackService extends RenameMe<MessageToService> {
    private AirportService airportService;

    @Autowired
    public PushbackService(AirportService airportService) {
        this.airportService = airportService;

        this.airportService.onSendMessageToPushbackService(messageQueue::add);
    }

    public void finished() {
        airportService.pushbackFinished();
    }
}
