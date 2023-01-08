package com.example.server.controller;

import com.example.server.service.BoardingService;
import com.example.server.service.CateringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("catering")
public class CateringServiceController {
    @Autowired
    private CateringService cateringService;
}
