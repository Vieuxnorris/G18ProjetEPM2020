package be.heh.entity;

import be.heh.Context;
import be.heh.usecase.AddSalariedEmployee;
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

       AddSalariedEmployee t = new AddSalariedEmployee(empID, "titi", "rue truc",1000);
       t.execute();
       Employee e = Context.employeeGateway.getEmployee(empID);
       assertNotNull(e);

       DeleteEmployee de = new DeleteEmployee(empID);
       de.execute();

       Employee emp = Context.employeeGateway.getEmployee(empID);
       assertNull(emp);
   }
}
