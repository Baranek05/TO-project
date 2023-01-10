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
    private Consumer<MessageToService> sendMessageToPilotService, sendMessageToLuggageService, sendMessageToBoardingService, sendMessageToCleaningService, sendMessageToCateringService, sendMessageToPushbackService,sendMessageToTankingService;

    public AirportService () {
        this.state = new ReadyState();
        state.setContext(this);
    }
    public void changeState(AirportState state) {
        this.state = state;
    }
    public void onSendMessageToPilotService(Consumer<MessageToService> action) {
        sendMessageToPilotService = action;
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

    public void sendMessageFromStandManager(MessageAssignTimeFromStandManager messageAssignTimeFromStandManagerService) {
        if (this.state instanceof GeneralManagerState) {
            changeState(new StandManagerState());
            state.setContext(this);

        } else if (!(this.state instanceof StandManagerState)) {
            return;
        }
        var messageToService = new MessageToService(new MessageAssignTimeToService(messageAssignTimeFromStandManagerService.message(),
                messageAssignTimeFromStandManagerService.minutes()), null);

        switch (messageAssignTimeFromStandManagerService.service()) {
            case LUGGAGE_SERVICE -> sendMessageToLuggageService.accept(messageToService);
            case BOARDING_SERVICE -> sendMessageToBoardingService.accept(messageToService);
            case CLEANING_SERVICE -> sendMessageToCleaningService.accept(messageToService);
            case CATERING_SERVICE -> sendMessageToCateringService.accept(messageToService);
            case TANKING_SERVICE -> sendMessageToTankingService.accept(messageToService);
            case PUSHBACK_SERVICE -> sendMessageToPushbackService.accept(messageToService);
        }
    }

    public void standManagerFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));
        if (this.state instanceof StandManagerState) {
            changeState(new LuggageArrivalState());
            state.setContext(this);
            sendMessageToLuggageService.accept(messageStartToService);
            sendMessageToBoardingService.accept(messageStartToService);
        }
    }

    public void luggageFinished() {
        if (this.state instanceof LuggageArrivalState) {
            changeState(new BoardingArrivalState());
            state.setContext(this);
        }
    }

    public void boardingFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));
        if (this.state instanceof BoardingArrivalState) {
            changeState(new CleaningState());
            state.setContext(this);
            sendMessageToCleaningService.accept(messageStartToService);
        }
    }

    public void cleaningFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));
        if (this.state instanceof CleaningState) {
            changeState(new TankingState());
            state.setContext(this);
            sendMessageToTankingService.accept(messageStartToService);
        }
    }

    public void tankingFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));
        if (this.state instanceof TankingState) {
            changeState(new CateringState());
            state.setContext(this);
            sendMessageToCateringService.accept(messageStartToService);
        }
    }

    public void cateringFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));
        if (this.state instanceof CateringState) {
            changeState(new LuggageDepartureState());
            state.setContext(this);
            sendMessageToLuggageService.accept(messageStartToService);
            sendMessageToBoardingService.accept(messageStartToService);
        }
    }

    public void luggageDepartureFinished() {
        if (this.state instanceof LuggageDepartureState) {
            changeState(new BoardingDepartureState());
            state.setContext(this);
        }
    }

    public void boardingDepartureFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));
        if (this.state instanceof BoardingDepartureState) {
            changeState(new PilotToPushbackState());
            state.setContext(this);
           sendMessageToPilotService.accept(messageStartToService);
        }
    }

    public void pilotFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));
        if (this.state instanceof PilotToPushbackState) {
            changeState(new PushbackState());
            state.setContext(this);
            sendMessageToPushbackService.accept(messageStartToService);
        }
    }

    public void pushbackFinished() {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"));
        if (this.state instanceof PushbackState) {
            changeState(new PushbackToPilotState());
            state.setContext(this);
            sendMessageToPilotService.accept(messageStartToService);
        }
    }



}
