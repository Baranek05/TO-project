package com.example.server.service.state;

import com.example.server.service.AirportService;
import com.example.server.service.state.AirportState;

public class ReadyState implements AirportState {
public AirportService context;

    @Override
    public void setContext(AirportService context) {
        this.context = context;
    }
}
