package com.example.server.service;

import com.example.server.model.*;
import com.example.server.service.state.*;
import org.springframework.stereotype.Service;


import java.util.function.Consumer;

@Service
public class AirportService {
    public AirportState state;

    private Consumer<MessageToGeneralManagerService> sendMessageToGeneralManagerService;
    private Consumer<MessageToStandManagerService> sendMessageToStandManagerService;
    private Consumer<MessageToService> sendMessageToLuggageService;
    private Consumer<MessageToService> sendMessageToBoardingService;
    private Consumer<MessageToService> sendMessageToCleaningService;
    private Consumer<MessageToService> sendMessageToCateringService;
    private Consumer<MessageToService> sendMessageToPushbackService;
    private Consumer<MessageToService> sendMessageToTankingService;


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
    public void onSendMessageToStandManagerService(Consumer<MessageToStandManagerService> action) {
        sendMessageToStandManagerService = action;
    }
    public void onSendMessageToLuggageService(Consumer<MessageToService> action) {
        sendMessageToLuggageService = action;
    }
    public void onSendMessageToBoardingService(Consumer<MessageToService> action) {
        sendMessageToBoardingService = action;
    }
    public void onSendMessageToCleaningService(Consumer<MessageToService> action) {
        sendMessageToCleaningService = action;
    }
    public void onSendMessageToCateringService(Consumer<MessageToService> action) {
        sendMessageToCateringService = action;
    }
    public void onSendMessageToTankingService(Consumer<MessageToService> action) {
        sendMessageToTankingService = action;
    }
    public void onSendMessageToPushbackService(Consumer<MessageToService> action) {
        sendMessageToPushbackService = action;
    }
    public void pilotLanded() {
        if (this.state instanceof ReadyState) {
            changeState(new LandedState());
            state.setContext(this);

            sendMessageToGeneralManagerService.accept(new MessageToGeneralManagerService());
        }
    }
    public void sendMessageFromGeneralManager(MessageFromGeneralManagerService messageFromGeneralManagerService) {
        if (this.state instanceof LandedState) {
            changeState(new GeneralManagerState());
            state.setContext(this);
            MessageToStandManagerService messageToStandManagerService = new MessageToStandManagerService(
                    messageFromGeneralManagerService.message(),
                    messageFromGeneralManagerService.minutes()
            );
            sendMessageToStandManagerService.accept(messageToStandManagerService);
        }
    }

    public void sendMessageFromStandManager(MessageFromStandManagerService messageFromStandManagerService) {
        if (this.state instanceof GeneralManagerState) {
            changeState(new StandManagerState());
            state.setContext(this);

        } else if (!(this.state instanceof StandManagerState)) {
            return;
        }
        MessageToService messageToService = new MessageToService(
                messageFromStandManagerService.message(),
                messageFromStandManagerService.minutes()
        );
        switch (messageFromStandManagerService.service()) {
            case LUGGAGE_SERVICE -> sendMessageToLuggageService.accept(messageToService);
            case BOARDING_SERVICE -> sendMessageToBoardingService.accept(messageToService);
            case CLEANING_SERVICE -> sendMessageToCleaningService.accept(messageToService);
            case CATERING_SERVICE -> sendMessageToCateringService.accept(messageToService);
            case TANKING_SERVICE -> sendMessageToTankingService.accept(messageToService);
            case PUSHBACK_SERVICE -> sendMessageToPushbackService.accept(messageToService);
        }
    }


}
