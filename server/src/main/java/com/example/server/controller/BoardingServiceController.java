package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.BoardingService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("boarding")
public class BoardingServiceController extends MessageController<MessageToService, BoardingService>{
    protected BoardingServiceController(BoardingService boardingService) {
        super(boardingService);
    }

    @PostMapping("/sendfinished")
    public void postMessage(@RequestBody int flightNumber) {
        service.finished(flightNumber);
    }

    @PostMapping("/sendfinisheddeparture")
    public void postDepartureMessage() {
        service.finishedDeparture();
    }
}
