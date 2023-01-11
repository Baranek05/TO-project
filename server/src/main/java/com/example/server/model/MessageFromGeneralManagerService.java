package com.example.server.model;


import java.util.UUID;

public record MessageFromGeneralManagerService(UUID flightNumber, String message, int minutes) {
}
