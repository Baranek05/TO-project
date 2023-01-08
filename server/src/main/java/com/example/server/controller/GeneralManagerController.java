package com.example.server.controller;

import com.example.server.model.MessageToGeneralManagerService;
import com.example.server.service.GeneralManagerService;
import com.example.server.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("generalmanager")
public class GeneralManagerController {

    @Autowired
    private GeneralManagerService generalManagerService;

    @GetMapping("/getmessage")
    public MessageToGeneralManagerService getMessage() {
        return generalManagerService.getMessage();
    }

    @PostMapping("/message")
    public void postLanded() {
        generalManagerService.sendMessage();
    }
}
