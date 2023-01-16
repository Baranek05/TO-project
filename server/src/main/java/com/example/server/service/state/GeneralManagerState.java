package com.example.server.service.state;

import com.example.server.model.*;
import com.example.server.service.FlightService;

public class GeneralManagerState extends AbstractFlightState {
    public GeneralManagerState(FlightService context) {
        super(context);
    }


    @Override
    public void sendMessageFromGeneralManager(MessageFromGeneralManagerService messageFromGeneralManagerService) {
        this.context.changeState(new StandManagerState(this.context));

        MessageToStandManagerService messageToStandManagerService = new MessageToStandManagerService(
                messageFromGeneralManagerService.message(),
                messageFromGeneralManagerService.minutes(),
                messageFromGeneralManagerService.flightNumber()
        );
        this.context.sendMessageToStandManagerService.accept(messageToStandManagerService);

    }
}