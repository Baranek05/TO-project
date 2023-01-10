package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.PilotService;
import com.example.server.service.PushbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("pilot")
public class PilotController extends MessageController<MessageToService, PilotService> {


    protected PilotController(PilotService pilotService) {
        super(pilotService);
    }

    @PostMapping("/landed")
        public void postLanded() {
            service.landed();
        }

    @PostMapping("/sendfinished")
    public void postMessage() {
        service.finished();
    }

}
