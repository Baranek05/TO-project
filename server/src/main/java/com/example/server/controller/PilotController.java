package com.example.server.controller;

import com.example.server.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("pilot")
public class PilotController{


    @Autowired
    private PilotService pilotService;

        @PostMapping("/landed")
        public void postLanded() {
            pilotService.landed();
        }

}
