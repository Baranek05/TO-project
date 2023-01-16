package com.example.server.model;

import java.util.UUID;

public record MessageToStandManagerService(String message, int minutes, int flightNumber) {
}

