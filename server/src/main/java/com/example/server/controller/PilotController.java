package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.AirportService;
import com.example.server.service.PilotService;
import com.example.server.service.Services;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController()
@RequestMapping("pilot")
public class PilotController extends MessageController<MessageToService, PilotService> {


    protected PilotController(AirportService airportService) {
        super(airportService, Services::pilotService);
    }

    @PostMapping("/landed")
    public void postLanded(@RequestBody int flightNumber) {
        airportService.getMessage(flightNumber).pilotService().landed();
    }

    @PostMapping("/finished")
    public void postMessage(@RequestBody int flightNumber) {
        airportService.getMessage(flightNumber).pilotService().finished();
    }


}
