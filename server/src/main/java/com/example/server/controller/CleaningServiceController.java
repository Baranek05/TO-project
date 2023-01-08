package com.example.server.controller;

import com.example.server.service.CateringService;
import com.example.server.service.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("cleaning")
public class CleaningServiceController {
    @Autowired
    private CleaningService cleaningService;
}
