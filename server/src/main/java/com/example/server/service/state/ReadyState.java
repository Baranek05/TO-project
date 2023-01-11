package com.example.server.service.state;

import com.example.server.model.MessageToGeneralManagerService;
import com.example.server.service.FlightService;

public class ReadyState extends AbstractFlightState {
    public ReadyState(FlightService context) {
        super(context);
    }


    @Override
    public void pilotLanded() {
        this.context.changeState(new GeneralManagerState(this.context));
        this.context.sendMessageToGeneralManagerService.accept(new MessageToGeneralManagerService());    }
}