package service;

import model.Employee;
import model.Task;
import storage.EmployeeDataBase;

import java.util.List;

public class EmployeeService {
    private final EmployeeDataBase employeeDataBase;

    public EmployeeService() {
        this.employeeDataBase = new EmployeeDataBase();
    }

    public void addEmployee(Employee employee){
        employeeDataBase.save(employee);
    }

    public List<Employee> getAvailableEmployeesByResponsibility(Task responsible){
        return employeeDataBase.getAvailableOnPosition(responsible);
    }

    public void markEmployeeAsBusy(Employee employee){
        employeeDataBase.markBusy(employee);
    }

    public void markEmployeeAvailable(Employee employee){
        employeeDataBase.markAvailable(employee);
    }


}
