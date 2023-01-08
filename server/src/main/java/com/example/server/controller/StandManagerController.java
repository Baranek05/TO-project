package com.example.server.controller;

import com.example.server.model.MessageFromGeneralManagerService;
import com.example.server.model.MessageToGeneralManagerService;
import com.example.server.model.MessageToStandManagerService;
import com.example.server.service.GeneralManagerService;
import com.example.server.service.PushbackService;
import com.example.server.service.StandManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("standmanager")
public class StandManagerController {
    @Autowired
    private StandManagerService standManagerService;

    @GetMapping("/getmessage")
    public MessageToStandManagerService getMessage() {
        return standManagerService.getMessage();
    }

}
