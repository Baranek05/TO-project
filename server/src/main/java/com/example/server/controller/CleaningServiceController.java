package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.AirportService;
import com.example.server.service.CleaningService;
import com.example.server.service.Services;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("cleaning")
public class CleaningServiceController extends MessageController<MessageToService, CleaningService>{

    protected CleaningServiceController(AirportService airportService) {
        super(airportService, Services::cleaningService);
    }

    @PostMapping("/finished")
    public void postMessage(@RequestBody UUID flightNumber) {
        airportService.getMessage(flightNumber).cleaningService().finished();
    }
}
