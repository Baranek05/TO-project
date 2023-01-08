package com.example.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CateringService {
    @Autowired
    private AirportService airportService;
}
