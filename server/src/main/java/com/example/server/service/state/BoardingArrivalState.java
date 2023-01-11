package com.example.server.service.state;

import com.example.server.model.MessageStartToService;
import com.example.server.model.MessageToService;
import com.example.server.service.FlightService;

public class BoardingArrivalState extends AbstractFlightState {
    public BoardingArrivalState(FlightService context) {
        super(context);
    }

    @Override
    public void boardingFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));

        this.context.changeState(new CleaningState(this.context));
        this.context.sendMessageToCleaningService.accept(messageStartToService);
    }
}
