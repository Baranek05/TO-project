package com.example.server.service.state;

import com.example.server.model.MessageStartToService;
import com.example.server.model.MessageToService;
import com.example.server.service.FlightService;


public class PushbackState extends AbstractFlightState {
    public PushbackState(FlightService context) {
        super(context);
    }

    @Override
    public void pushbackFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));

        this.context.changeState(new ReadyState(this.context));
        this.context.sendMessageToPilotService.accept(messageStartToService);
    }
}