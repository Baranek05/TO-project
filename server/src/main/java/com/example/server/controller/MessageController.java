package com.example.server.controller;

import com.example.server.service.AirportService;
import com.example.server.service.MessageQueue;
import com.example.server.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;
import java.util.function.Function;

public abstract class MessageController<TMessage, TService extends MessageQueue<TMessage>> {

    protected final AirportService airportService;
    private final Function<Services, TService> serviceSelector;

    @Autowired
    protected MessageController(AirportService airportService, Function<Services, TService> serviceSelector) {
        this.airportService = airportService;
        this.serviceSelector = serviceSelector;
    }

    @GetMapping("/getmessage")
    public TMessage getMessage(@RequestParam int flightNumber) {
        var get = airportService.getMessage(flightNumber);
        var service = serviceSelector.apply(get);
        return service.getMessage();
    }


}
