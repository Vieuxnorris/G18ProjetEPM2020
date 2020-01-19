package be.heh.EPGMG5.usecase;

import be.heh.EPGMG5.entity.Employee;
import be.heh.EPGMG5.entity.PaymentMethod;

abstract class ChgEmpPayementMethod extends ChgEmp {

    ChgEmpPayementMethod(int empId) {
        super(empId);
    }

    public abstract PaymentMethod makePayementMethod();

    @Override
    public void change(Employee employee) {
        employee.setPayMethod(makePayementMethod());
    }

/*    public abstract PaymentMethod getMethod();*/
}
