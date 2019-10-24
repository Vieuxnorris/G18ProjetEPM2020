package be.heh.gateways;

import be.heh.entity.Employee;

public interface EmployeeGateway {
    Employee getEmployee(int empId);

    void save(int empId, Employee employee);

    void deleteEmployee(int empId);
}
