package com.example.server.controller;

import com.example.server.service.PilotService;
import com.example.server.service.PushbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("pushback")
public class PushbackServiceController {
    @Autowired
    private PushbackService pushbackService;

}
