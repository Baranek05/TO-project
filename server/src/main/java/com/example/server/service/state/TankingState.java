package com.example.server.service.state;

import com.example.server.model.MessageStartToService;
import com.example.server.model.MessageToService;
import com.example.server.service.FlightService;

public class TankingState extends AbstractFlightState {
    public TankingState(FlightService context) {
        super(context);
    }

    @Override
    public void tankingFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));
        this.context.cateringFinished();
        this.context.changeState(new CateringState(this.context));
        this.context.sendMessageToCateringService.accept(messageStartToService);
    }
}