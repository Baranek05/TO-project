package com.example.storage;

import com.example.server.model.Employee;
import com.example.server.model.ServiceType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDataBase {
    List<Employee> employeeList;

    public EmployeeDataBase() {
        this.employeeList = new ArrayList<>();
    }

    public void save(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> getAvailableOnPosition(ServiceType serviceType) {
        return employeeList.stream()
                .filter(employee -> !employee.isAssigned())
                .filter(employee -> employee.getServiceType().equals(serviceType))
                .toList();
    }

}
