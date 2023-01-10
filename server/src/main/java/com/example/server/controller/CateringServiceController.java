package com.example.server.controller;

import com.example.server.model.MessageToService;
import com.example.server.service.BoardingService;
import com.example.server.service.CateringService;
import com.example.server.service.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("catering")
public class CateringServiceController extends MessageController<MessageToService, CateringService> {
    protected CateringServiceController(CateringService cateringService) {
        super(cateringService);
    }

    @PostMapping("/sendfinished")
    public void postMessage() {
        service.finished();
    }
}
