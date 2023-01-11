package com.example.server.service.state;

import com.example.server.model.MessageStartToService;
import com.example.server.model.MessageToService;
import com.example.server.service.FlightService;

public class CleaningState extends AbstractFlightState {
    public CleaningState(FlightService context) {
        super(context);
    }

    @Override
    public void cleaningFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));

        this.context.changeState(new TankingState(this.context));
        this.context.sendMessageToTankingService.accept(messageStartToService);
    }
}
