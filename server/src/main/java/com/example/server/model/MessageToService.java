package com.example.server.model;

public record MessageToService(MessageAssignTimeToService assignTime, MessageStartToService start, int flightNumber) {
}
