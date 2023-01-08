package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.CateringService;
import com.example.server.service.PilotService;
import com.example.server.service.PushbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("pushback")
public class PushbackServiceController extends MessageController<MessageToService, PushbackService> {


    protected PushbackServiceController(PushbackService pushbackService) {
        super(pushbackService);
    }
}
