package com.example.server.controller;

import com.example.server.model.MessageFromGeneralManagerService;
import com.example.server.model.MessageToGeneralManagerService;
import com.example.server.service.GeneralManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("generalmanager")
public class GeneralManagerController extends MessageController<MessageToGeneralManagerService, GeneralManagerService>{


    protected GeneralManagerController(GeneralManagerService generalManagerService) {
        super(generalManagerService);
    }

    @PostMapping("/sendmessage")
    public void postMessage(@RequestBody MessageFromGeneralManagerService messageFromGeneralManagerService) {
        service.sendMessage(messageFromGeneralManagerService);
    }
}
