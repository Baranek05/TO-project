package com.example.server.model;


import java.util.UUID;

public record MessageFromGeneralManagerService(int flightNumber, String message, int minutes) {
}
