package com.example.server.service;

import com.example.server.model.MessageToService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CleaningService extends RenameMe<MessageToService> {
    private AirportService airportService;

    @Autowired
    public CleaningService(AirportService airportService) {
        this.airportService = airportService;

        this.airportService.onSendMessageToCleaningService(messageQueue::add);
    }
    public void finished() {
        airportService.cleaningFinished();
    }

}
