package com.example.server.service;

import com.example.server.model.Employee;
import com.example.server.model.MessageAssignTimeFromStandManager;
import com.example.server.model.ServiceType;
import com.example.server.model.WorkOrder;
import com.example.server.storage.WorkDataBase;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    private final WorkDataBase workDataBase;
    private final EmployeeService employeeService;

    public WorkService(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.workDataBase = new WorkDataBase();
    }

    public void createAndAssignWork(MessageAssignTimeFromStandManager messageAssignTimeFromStandManagerService) {
        List<Employee> employees = employeeService.getAllEmployees();

        Optional<Employee> availableEmployee = getAvailableEmployee(employees, messageAssignTimeFromStandManagerService.service());

        if (availableEmployee.isEmpty()) {
            return;
        }

        WorkOrder workOrder = new WorkOrder.Builder()
                .flightNumber(messageAssignTimeFromStandManagerService.flightNumber())
                .assignee(availableEmployee.get())
                .estimatedTimeInMinutes(messageAssignTimeFromStandManagerService.minutes())
                .serviceType(messageAssignTimeFromStandManagerService.service())
                .startDate(Instant.now())
                .build();

        workDataBase.save(workOrder);
    }

    private Optional<Employee> getAvailableEmployee(List<Employee> employees, ServiceType serviceType) {
        return employees.stream()
                .filter(employee -> !assignedEmployees().contains(employee))
                .filter(employee -> employee.getServiceType().equals(serviceType))
                .findFirst();
    }

    private List<Employee> assignedEmployees() {
        return workDataBase.findAll().stream().map(WorkOrder::getAssignee).toList();
    }

    public List<WorkOrder> getAll() {
        return workDataBase.findAll();
    }

    public void completeStage(int flightNumber, ServiceType serviceType) {
        workDataBase.findByFlight(flightNumber).stream()
                .filter(workOrder -> workOrder.getServiceType().equals(serviceType))
                .findFirst()
                .ifPresent(WorkOrder::complete);
    }
}
