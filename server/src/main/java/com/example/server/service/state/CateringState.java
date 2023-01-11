package com.example.server.service.state;

import com.example.server.model.MessageStartToService;
import com.example.server.model.MessageToService;
import com.example.server.service.FlightService;

public class CateringState extends AbstractFlightState {
    public CateringState(FlightService context) {
        super(context);
    }

    @Override
    public void cateringFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));

        this.context.changeState(new BoardingDepartureState(this.context));
        this.context.sendMessageToBoardingService.accept(messageStartToService);
        this.context.sendMessageToLuggageService.accept(messageStartToService);
    }
}