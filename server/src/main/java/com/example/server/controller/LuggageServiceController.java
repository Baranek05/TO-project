package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.LuggageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("luggage")
public class LuggageServiceController extends MessageController<MessageToService, LuggageService>{

    protected LuggageServiceController(LuggageService luggageService) {
        super(luggageService);
    }
}
