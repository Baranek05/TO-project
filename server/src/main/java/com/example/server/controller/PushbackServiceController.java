package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.AirportService;
import com.example.server.service.PushbackService;
import com.example.server.service.Services;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("pushback")
public class PushbackServiceController extends MessageController<MessageToService, PushbackService> {

    protected PushbackServiceController(AirportService airportService) {
        super(airportService, Services::pushbackService);
    }

    @PostMapping("/finished")
    public void postMessage(@RequestBody UUID flightNumber) {
        airportService.getMessage(flightNumber).pushbackService().finished();
    }
}
