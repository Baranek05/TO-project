package com.example.server.service;

import com.example.server.model.*;

public class StandManagerService extends MessageQueue<MessageToStandManagerService> {
    private final FlightService flightService;

    public StandManagerService(FlightService flightService) {
        this.flightService = flightService;

        this.flightService.onSendMessageToStandManagerService(messageQueue::add);
    }

    public void sendMessage(MessageAssignTimeFromStandManager messageAssignTimeFromStandManagerService) {
        flightService.sendMessageFromStandManager(messageAssignTimeFromStandManagerService);
    }
    public void finished() {
        flightService.standManagerFinished();
    }

    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    public Optional<Employee> findAvailableEmployee(ServiceType service) {
        return employeeService.getAvailableEmployeesByResponsibility(service).stream().findFirst();
    }

    public void saveWorkOrder(WorkOrder build) {
        this.workService.addWork(build);
        this.employeeService.assign(build.getAssignee(), build.getUuid());
    }
}
