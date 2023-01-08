package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.BoardingService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("boarding")
public class BoardingServiceController extends MessageController<MessageToService, BoardingService>{
    protected BoardingServiceController(BoardingService boardingService) {
        super(boardingService);
    }
}
