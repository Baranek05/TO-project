package com.example.server.service.state;

import com.example.server.model.MessageAssignTimeFromStandManager;
import com.example.server.model.MessageFromGeneralManagerService;

public interface FlightState {
    void pilotLanded();
    void sendMessageFromGeneralManager(MessageFromGeneralManagerService messageFromGeneralManagerService);
    void sendMessageFromStandManager(MessageAssignTimeFromStandManager messageAssignTimeFromStandManagerService);
    void standManagerFinished();

    void luggageFinished();

    void boardingFinished();

    void cleaningFinished();

    void tankingFinished();

    void cateringFinished();

    void luggageDepartureFinished();

    void boardingDepartureFinished();

    void pilotFinished();

    void pushbackFinished();
}
