package be.heh.doubles;

import be.heh.entity.Employee;
import be.heh.gateways.EmployeeGateway;

import java.util.Map;
import java.util.HashMap;

public class InMemoryEmployeeGateway implements EmployeeGateway {
    private Map<Integer, Employee> employees = new HashMap<>();

    @Override
    public Employee getEmployee(int empId) {
        return employees.get(empId);
    }

    @Override
    public void save(int empId, Employee employee) {
        employees.put(empId, employee);
    }

    @Override
    public void deleteEmployee(int empId) {
        employees.remove(empId);
    }
}
