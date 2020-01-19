package be.heh.EPGMG5.doubles;

import be.heh.EPGMG5.gateways.EmployeeGateway;
import be.heh.EPGMG5.gateways.EmployeeGateway;
import be.heh.EPGMG5.entity.Employee;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

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

    @Override
    public Set<Integer> getAllEmployeeIds() {
        return employees.keySet();
    }
}
