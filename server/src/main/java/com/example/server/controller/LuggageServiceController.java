package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.AirportService;
import com.example.server.service.LuggageService;
import com.example.server.service.Services;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("luggage")
public class LuggageServiceController extends MessageController<MessageToService, LuggageService>{

    protected LuggageServiceController(AirportService airportService) {
        super(airportService, Services::luggageService);
    }

    @PostMapping("/finished")
    public void postMessage(@RequestBody int flightNumber) {
        airportService.getMessage(flightNumber).luggageService().finished();
    }

    @PostMapping("/finisheddeparture")
    public void postDepartureMessage(@RequestBody int flightNumber) {
        airportService.getMessage(flightNumber).luggageService().finishedDeparture();
    }
}
