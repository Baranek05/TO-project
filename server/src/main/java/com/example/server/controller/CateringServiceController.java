package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.AirportService;
import com.example.server.service.CateringService;
import com.example.server.service.Services;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("catering")
public class CateringServiceController extends MessageController<MessageToService, CateringService> {
    protected CateringServiceController(AirportService airportService) {
        super(airportService, Services::cateringService);
    }

    @PostMapping("/finished/{flightNumber}")
    public void postMessage(@PathVariable int flightNumber) {
        airportService.getMessage(flightNumber).cateringService().finished(flightNumber);
    }
}
