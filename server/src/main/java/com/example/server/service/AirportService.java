package com.example.server.service;

import com.example.server.model.MessageToGeneralManagerService;
import com.example.server.service.state.AirportState;
import com.example.server.service.state.GeneralManagerState;
import com.example.server.service.state.LandedState;
import com.example.server.service.state.ReadyState;
import org.springframework.stereotype.Service;


import java.util.function.Consumer;

@Service
public class AirportService {
    public AirportState state;

    private Consumer<MessageToGeneralManagerService> sendMessageToGeneralManagerService;

    public AirportService () {
        this.state = new ReadyState();
        state.setContext(this);
    }
    public void changeState(AirportState state) {
        this.state = state;
    }
    public void onSendMessageToPilotService(Consumer<MessageToPilotService> action) {
    }
    public void onSendMessageToGeneralManagerService(Consumer<MessageToGeneralManagerService> action) {
        sendMessageToGeneralManagerService = action;
    }
    public void pilotLanded() {
        if (this.state instanceof ReadyState) {
            changeState(new LandedState());
            state.setContext(this);

            sendMessageToGeneralManagerService.accept(new MessageToGeneralManagerService());
        }
    }
    public void sendMessageToStandManager() {
        if (this.state instanceof LandedState) {
            changeState(new GeneralManagerState());
            state.setContext(this);

        }
    }

}
