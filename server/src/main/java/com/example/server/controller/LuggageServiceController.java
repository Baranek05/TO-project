package com.example.server.controller;

import com.example.server.service.GeneralManagerService;
import com.example.server.service.LuggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("luggage")
public class LuggageServiceController {

    @Autowired
    private LuggageService luggageService;
}
