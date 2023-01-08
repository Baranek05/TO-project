package com.example.server.controller;

import com.example.server.model.MessageFromGeneralManagerService;
import com.example.server.model.MessageToGeneralManagerService;
import com.example.server.service.GeneralManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("generalmanager")
public class GeneralManagerController {

    @Autowired
    private GeneralManagerService generalManagerService;

    @GetMapping("/getmessage")
    public MessageToGeneralManagerService getMessage() {
        return generalManagerService.getMessage();
    }

    @PostMapping("/sendmessage")
    public void postLanded(@RequestBody MessageFromGeneralManagerService messageFromGeneralManagerService) {
        generalManagerService.sendMessage(messageFromGeneralManagerService);
    }
}
