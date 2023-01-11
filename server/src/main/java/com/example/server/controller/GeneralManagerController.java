package com.example.server.controller;

import com.example.server.model.MessageFromGeneralManagerService;
import com.example.server.model.MessageToGeneralManagerService;
import com.example.server.service.AirportService;
import com.example.server.service.GeneralManagerService;
import com.example.server.service.Services;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("generalmanager")
public class GeneralManagerController extends MessageController<MessageToGeneralManagerService, GeneralManagerService>{


    protected GeneralManagerController(AirportService airportService) {
        super(airportService, Services::generalManagerService);
    }

    @PostMapping("/finished")
    public void postMessage(@RequestBody MessageFromGeneralManagerService messageFromGeneralManagerService) {
        airportService.getMessage(messageFromGeneralManagerService.flightNumber()).generalManagerService().sendMessage(messageFromGeneralManagerService);
    }

}
