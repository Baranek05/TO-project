package com.example.server.service.state;

import com.example.server.model.MessageStartToService;
import com.example.server.model.MessageToService;
import com.example.server.service.FlightService;

public class BoardingDepartureState extends AbstractFlightState {
    public BoardingDepartureState(FlightService context) {
        super(context);
    }

    @Override
    public void boardingDepartureFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));

        this.context.changeState(new LuggageDepartureState(this.context));

    }
}
