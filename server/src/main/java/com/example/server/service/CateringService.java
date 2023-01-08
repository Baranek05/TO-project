package com.example.server.service;

import com.example.server.model.MessageToService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CateringService extends RenameMe<MessageToService> {
    private AirportService airportService;

    @Autowired
    public CateringService(AirportService airportService) {
        this.airportService = airportService;

        this.airportService.onSendMessageToCateringService(messageQueue::add);
    }
}
