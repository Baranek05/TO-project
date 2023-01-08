package com.example.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TankingService {

    @Autowired
    private AirportService airportService;
}
