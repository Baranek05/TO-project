package com.example.server.service;

import com.example.server.model.*;
import com.example.server.service.state.*;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class AirportService {
    public Map<Integer, AirportState> stateByFlight;

    private Consumer<MessageToGeneralManagerService> sendMessageToGeneralManagerService;
    private Consumer<MessageToStandManagerService> sendMessageToStandManagerService;
    private Consumer<MessageToService> sendMessageToPilotService, sendMessageToLuggageService, sendMessageToBoardingService, sendMessageToCleaningService, sendMessageToCateringService, sendMessageToPushbackService,sendMessageToTankingService;
    
    public AirportService () {
        stateByFlight = new HashMap<>();
    }

    public void changeState(int flightNumber, AirportState state) {
        this.stateByFlight.put(flightNumber, state);
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
    public void pilotLanded(int flightNumber) {
        if(!this.stateByFlight.containsKey(flightNumber)) {
            changeState(flightNumber, new LandedState());
            stateByFlight.get(flightNumber).setContext(this);

            sendMessageToGeneralManagerService.accept(new MessageToGeneralManagerService(flightNumber));
        }
    }
    public void sendMessageFromGeneralManager(MessageFromGeneralManagerService messageFromGeneralManagerService) {
        int flightNumber = messageFromGeneralManagerService.flightNumber();
        if (this.stateByFlight.get(flightNumber) instanceof LandedState) {
            changeState(flightNumber, new GeneralManagerState());
            stateByFlight.get(flightNumber).setContext(this);
            MessageToStandManagerService messageToStandManagerService = new MessageToStandManagerService(
                    messageFromGeneralManagerService.message(),
                    messageFromGeneralManagerService.minutes(),
                    flightNumber
            );
            sendMessageToStandManagerService.accept(messageToStandManagerService);
        }
    }

    public void sendMessageFromStandManager(MessageAssignTimeFromStandManager messageAssignTimeFromStandManagerService, StandManagerService standManagerService) {
        int flightNumber = messageAssignTimeFromStandManagerService.flightNumber();
        if (this.stateByFlight.get(flightNumber) instanceof GeneralManagerState) {
             changeState(flightNumber, new StandManagerState());
            stateByFlight.get(flightNumber).setContext(this);

        } else if (!(this.stateByFlight.get(flightNumber) instanceof StandManagerState)) {
            return;
        }

        Optional<Employee> availableEmployee = standManagerService.findAvailableEmployee(messageAssignTimeFromStandManagerService.service());

        if(availableEmployee.isEmpty()){
            return;
        }

        WorkOrder build = new WorkOrder.Builder()
                .flightNumber(flightNumber)
                .assignee(availableEmployee.get())
                .estimatedTimeInMinutes(messageAssignTimeFromStandManagerService.minutes())
                .startDate(Instant.now())
                .build();

        standManagerService.saveWorkOrder(build);

        var messageToService = new MessageToService(
                new MessageAssignTimeToService(
                        messageAssignTimeFromStandManagerService.message(),
                messageAssignTimeFromStandManagerService.minutes()),
                null,
                build.getFlightNumber());

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
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"), 0);
        var flightNumber = 0;
        if (this.stateByFlight.get(flightNumber) instanceof StandManagerState) {
             changeState(flightNumber, new LuggageArrivalState());
            stateByFlight.get(flightNumber).setContext(this);
            sendMessageToLuggageService.accept(messageStartToService);
            sendMessageToBoardingService.accept(messageStartToService);
        }
    }

    public void luggageFinished() {
        var flightNumber = 0;
        if (this.stateByFlight.get(flightNumber) instanceof LuggageArrivalState) {
             changeState(flightNumber, new BoardingArrivalState());
            stateByFlight.get(flightNumber).setContext(this);
        }
    }

    public void boardingFinished(int flightNumber) {
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"), flightNumber);
        if (this.stateByFlight.get(flightNumber) instanceof BoardingArrivalState) {
             changeState(flightNumber, new CleaningState());
            stateByFlight.get(flightNumber).setContext(this);
            sendMessageToCleaningService.accept(messageStartToService);
        }
    }

    public void cleaningFinished() {
        var flightNumber = 0;
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"), 0);
        if (this.stateByFlight.get(flightNumber) instanceof CleaningState) {
             changeState(flightNumber, new TankingState());
            stateByFlight.get(flightNumber).setContext(this);
            sendMessageToTankingService.accept(messageStartToService);
        }
    }

    public void tankingFinished() {
        var flightNumber = 0;
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"), 0);
        if (this.stateByFlight.get(flightNumber) instanceof TankingState) {
             changeState(flightNumber, new CateringState());
            stateByFlight.get(flightNumber).setContext(this);
            sendMessageToCateringService.accept(messageStartToService);
        }
    }

    public void cateringFinished() {
        var flightNumber = 0;
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"), 0);
        if (this.stateByFlight.get(flightNumber) instanceof CateringState) {
             changeState(flightNumber, new LuggageDepartureState());
            stateByFlight.get(flightNumber).setContext(this);
            sendMessageToLuggageService.accept(messageStartToService);
            sendMessageToBoardingService.accept(messageStartToService);
        }
    }

    public void luggageDepartureFinished() {
        var flightNumber = 0;
        if (this.stateByFlight.get(flightNumber) instanceof LuggageDepartureState) {
             changeState(flightNumber, new BoardingDepartureState());
            stateByFlight.get(flightNumber).setContext(this);
        }
    }

    public void boardingDepartureFinished() {
        var flightNumber = 0;
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"), 0);
        if (this.stateByFlight.get(flightNumber) instanceof BoardingDepartureState) {
             changeState(flightNumber, new PilotToPushbackState());
            stateByFlight.get(flightNumber).setContext(this);
           sendMessageToPilotService.accept(messageStartToService);
        }
    }

    public void pilotFinished() {
        var flightNumber = 0;
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"), 0);
        if (this.stateByFlight.get(flightNumber) instanceof PilotToPushbackState) {
             changeState(flightNumber, new PushbackState());
            stateByFlight.get(flightNumber).setContext(this);
            sendMessageToPushbackService.accept(messageStartToService);
        }
    }

    public void pushbackFinished() {
        var flightNumber = 0;
        var messageStartToService = new MessageToService(null, new MessageStartToService("START"), 0);
        if (this.stateByFlight.get(flightNumber) instanceof PushbackState) {
             changeState(flightNumber, new PushbackToPilotState());
            stateByFlight.get(flightNumber).setContext(this);
            sendMessageToPilotService.accept(messageStartToService);
        }
    }



}
