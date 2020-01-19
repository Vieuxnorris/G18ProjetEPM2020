package be.heh.EPGMG5.entity;

import be.heh.EPGMG5.Context;
import be.heh.EPGMG5.usecase.AddSalariedEmp;
import be.heh.EPGMG5.usecase.DeleteEmployee;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestRemoveEmployee {

   @Before
    public void setup()
   {
       TestSetup.setupContext();
   }

   @Test
    public void deleteEmployee(){
       int empID = 4;

       AddSalariedEmp t = new AddSalariedEmp(empID, "titi", "rue truc",1000);
       t.execute();
       Employee e = Context.employeeGateway.getEmployee(empID);
       assertNotNull(e);

       DeleteEmployee de = new DeleteEmployee(empID);
       de.execute();

       Employee emp = Context.employeeGateway.getEmployee(empID);
       assertNull(emp);
   }
}
