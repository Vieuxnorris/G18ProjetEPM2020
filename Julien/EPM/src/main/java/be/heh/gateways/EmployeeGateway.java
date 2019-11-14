package be.heh.gateways;

import be.heh.entity.Employee;

import java.util.Set;

public interface EmployeeGateway {
    Employee getEmployee(int empId);

    void save(int empId, Employee employee);

    void deleteEmployee(int empId);

    Set<Integer> getAllEmployeeIds();
}
