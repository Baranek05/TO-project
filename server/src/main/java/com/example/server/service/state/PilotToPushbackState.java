package com.example.server.service.state;

import com.example.server.service.AirportService;

public class PilotToPushbackState implements AirportState  {
    public AirportService context;

    @Override
    public void setContext(AirportService context) {
        this.context = context;
    }
}
