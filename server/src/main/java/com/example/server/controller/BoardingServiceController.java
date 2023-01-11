package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.AirportService;
import com.example.server.service.BoardingService;

import com.example.server.service.Services;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("boarding")
public class BoardingServiceController extends MessageController<MessageToService, BoardingService>{
    protected BoardingServiceController(AirportService airportService) {
        super(airportService, Services::boardingService);
    }

    @PostMapping("/finished")
    public void postMessage(@RequestBody UUID flightNumber) {
        airportService.getMessage(flightNumber).boardingService().finished();
    }

    @PostMapping("/finisheddeparture")
    public void postDepartureMessage(@RequestBody UUID flightNumber) {
        airportService.getMessage(flightNumber).boardingService().finishedDeparture();
    }
}
