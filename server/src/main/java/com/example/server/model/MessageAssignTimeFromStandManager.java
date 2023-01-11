package com.example.server.model;

import java.util.UUID;

public record MessageAssignTimeFromStandManager(UUID flightNumber, String message, int minutes, ServiceType service) {
}
