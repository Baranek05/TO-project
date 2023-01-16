package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.AirportService;
import com.example.server.service.BoardingService;
import com.example.server.service.Services;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("boarding")
public class BoardingServiceController extends MessageController<MessageToService, BoardingService>{
    protected BoardingServiceController(AirportService airportService) {
        super(airportService, Services::boardingService);
    }

    @PostMapping("/finished/{flightNumber}")
    public void postMessage(@PathVariable int flightNumber) {
        airportService.getMessage(flightNumber).boardingService().finished(flightNumber);
    }

    @PostMapping("/finisheddeparture/{flightNumber}")
    public void postDepartureMessage(@PathVariable int flightNumber) {
        airportService.getMessage(flightNumber).boardingService().finishedDeparture();
    }
}
