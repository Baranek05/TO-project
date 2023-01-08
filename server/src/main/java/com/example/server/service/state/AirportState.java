package com.example.server.service.state;

import com.example.server.service.AirportService;
import org.springframework.stereotype.Service;

@Service
public interface AirportState {

    void setContext(AirportService airportService);
}
