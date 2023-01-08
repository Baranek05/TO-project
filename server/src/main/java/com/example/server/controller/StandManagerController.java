package com.example.server.controller;

import com.example.server.service.PushbackService;
import com.example.server.service.StandManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("standmanager")
public class StandManagerController {
    @Autowired
    private StandManagerService standManagerService;
}
