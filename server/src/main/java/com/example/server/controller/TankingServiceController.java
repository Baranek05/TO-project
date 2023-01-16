package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.AirportService;
import com.example.server.service.Services;
import com.example.server.service.TankingService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("tanking")
public class TankingServiceController extends MessageController<MessageToService, TankingService> {

    protected TankingServiceController(AirportService airportService) {
        super(airportService, Services::tankingService);
    }

    @PostMapping("/finished/{flightNumber}")
    public void postMessage(@PathVariable int flightNumber) {
        airportService.getMessage(flightNumber).tankingService().finished(flightNumber);
    }
}
