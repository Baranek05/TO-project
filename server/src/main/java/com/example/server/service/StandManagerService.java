package com.example.server.service;

import com.example.server.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandManagerService extends RenameMe<MessageToStandManagerService>{

    private final AirportService airportService;
    private final EmployeeService employeeService;
    private final WorkService workService;

    @Autowired
    public StandManagerService(AirportService airportService, EmployeeService employeeService, WorkService workService) {
        this.airportService = airportService;
        this.employeeService = employeeService;
        this.workService = workService;

        this.airportService.onSendMessageToStandManagerService(messageQueue::add);
    }

    public void sendMessage(MessageAssignTimeFromStandManager messageAssignTimeFromStandManagerService) {
        airportService.sendMessageFromStandManager(messageAssignTimeFromStandManagerService, this);
    }
    public void finished() {
        airportService.standManagerFinished();
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
