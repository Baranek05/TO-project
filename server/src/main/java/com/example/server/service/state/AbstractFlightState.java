package com.example.server.service.state;

import com.example.server.model.MessageAssignTimeFromStandManager;
import com.example.server.model.MessageFromGeneralManagerService;
import com.example.server.service.FlightService;

public class AbstractFlightState implements FlightState {
    protected final FlightService context;

    public AbstractFlightState(FlightService context) {
        this.context = context;
    }

    @Override
    public void pilotLanded(int flightNumber) {
        throw new RuntimeException("bad state");
    }

    @Override
    public void sendMessageFromGeneralManager(MessageFromGeneralManagerService messageFromGeneralManagerService) {
        throw new RuntimeException("bad state");
    }

    @Override
    public void sendMessageFromStandManager(MessageAssignTimeFromStandManager messageAssignTimeFromStandManagerService) {
        throw new RuntimeException("bad state");
    }

    @Override
    public void standManagerFinished() {
        throw new RuntimeException("bad state");
    }

    @Override
    public void luggageFinished() {
        throw new RuntimeException("bad state");
    }

    @Override
    public void boardingFinished() {
        throw new RuntimeException("bad state");
    }

    @Override
    public void cleaningFinished() {
        throw new RuntimeException("bad state");
    }

    @Override
    public void tankingFinished() {
        throw new RuntimeException("bad state");
    }

    @Override
    public void cateringFinished() {
        throw new RuntimeException("bad state");
    }

    @Override
    public void luggageDepartureFinished() {
        throw new RuntimeException("bad state");
    }

    @Override
    public void boardingDepartureFinished() {
        throw new RuntimeException("bad state");
    }

    @Override
    public void pilotFinished() {
        throw new RuntimeException("bad state");
    }

    @Override
    public void pushbackFinished() {
        throw new RuntimeException("bad state");
    }
}
