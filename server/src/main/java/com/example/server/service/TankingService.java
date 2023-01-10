package com.example.server.service;

import com.example.server.model.MessageToService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TankingService extends RenameMe<MessageToService> {

    private AirportService airportService;

    @Autowired
    public TankingService(AirportService airportService) {
        this.airportService = airportService;

        this.airportService.onSendMessageToTankingService(messageQueue::add);
    }
    public void finished() {
        airportService.tankingFinished();
    }

}
