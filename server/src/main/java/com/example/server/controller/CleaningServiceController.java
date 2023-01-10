package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.BoardingService;
import com.example.server.service.CateringService;
import com.example.server.service.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("cleaning")
public class CleaningServiceController extends MessageController<MessageToService, CleaningService>{


    protected CleaningServiceController(CleaningService cleaningService) {
        super(cleaningService);
    }

    @PostMapping("/sendfinished")
    public void postMessage() {
        service.finished();
    }
}
