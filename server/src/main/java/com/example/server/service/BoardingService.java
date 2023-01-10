package com.example.server.service;

import com.example.server.model.MessageToService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardingService extends RenameMe<MessageToService> {

    private AirportService airportService;

    @Autowired
    public BoardingService(AirportService airportService) {
        this.airportService = airportService;

        this.airportService.onSendMessageToBoardingService(messageQueue::add);
    }

    public void finished() {
        airportService.boardingFinished();
    }
    public void finishedDeparture() {
        airportService.boardingDepartureFinished();
    }


}
