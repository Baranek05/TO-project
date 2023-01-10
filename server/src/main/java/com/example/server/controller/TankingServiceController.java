package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.PushbackService;
import com.example.server.service.StandManagerService;
import com.example.server.service.TankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("tanking")
public class TankingServiceController extends MessageController<MessageToService, TankingService> {

    protected TankingServiceController(TankingService tankingService) {
        super(tankingService);
    }

    @PostMapping("/sendfinished")
    public void postMessage() {
        service.finished();
    }
}
