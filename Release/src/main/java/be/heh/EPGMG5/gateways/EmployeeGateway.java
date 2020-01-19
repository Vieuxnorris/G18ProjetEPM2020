package be.heh.EPGMG5.gateways;

import be.heh.EPGMG5.entity.Employee;

import java.util.Set;

public interface EmployeeGateway {

    Employee getEmployee(int empId);

    void save(int empId, Employee employee);

    void deleteEmployee(int empId);

    Set<Integer> getAllEmployeeIds();
}
