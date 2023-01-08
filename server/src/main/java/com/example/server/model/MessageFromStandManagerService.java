package com.example.server.model;

public record MessageFromStandManagerService(String message, int minutes, ServiceType service) {
}
