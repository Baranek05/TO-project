package com.example.server.service.state;

import com.example.server.service.FlightService;


public class FinalState extends AbstractFlightState {
    public FinalState(FlightService context) {
        super(context);
    }

//    @Override
//    public void pilotFinished() {
//        this.context.changeState(new ReadyState(this.context));
//    }
}
