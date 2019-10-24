package be.heh.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PayrollDatabase {

    public static PayrollDatabase instance = new PayrollDatabase();

    private Map<Integer, Employee> Employees;
    private Map<Integer, Employee> UnionMembers;

    private PayrollDatabase()
    {
        Employees = new HashMap<>();
        UnionMembers = new HashMap<>();
    }

    public Employee getEmployee (int empID)
    {
        return Employees.get(empID);
    }

    public void clear()
    {
        Employees.clear();
    }

    public void addEmployee(int empid, Employee employee)
    {
        Employees.put(empid, employee);
    }

    public void deleteEmployee(int employID)
    {
        Employees.remove(employID);
    }

    public Employee getUnionMember (int memberID)
    {
        return UnionMembers.get(memberID);
    }

    public void addUnionMember (int memberId, Employee e)
    {
        UnionMembers.put(memberId, e);
    }

    public void removeUnionMember (int memberId)
    {
        UnionMembers.remove(memberId);
    }

    public Set<Integer> getAllEmployeeIds()
    {
        return Employees.keySet();
    }
}
