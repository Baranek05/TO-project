package com.example.server.service.state;

import com.example.server.model.MessageStartToService;
import com.example.server.model.MessageToService;
import com.example.server.service.FlightService;


public class LuggageArrivalState extends AbstractFlightState {
    public LuggageArrivalState(FlightService context) {
        super(context);
    }

    @Override
    public void luggageFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));

        this.context.changeState(new BoardingArrivalState(this.context));
        this.context.sendMessageToBoardingService.accept(messageStartToService);
    }
}
