package com.example.server.controller;

import com.example.server.service.StandManagerService;
import com.example.server.service.TankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("tanking")
public class TankingServiceController {
    @Autowired
    private TankingService tankingService;
}
