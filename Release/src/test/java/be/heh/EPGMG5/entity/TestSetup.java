package be.heh.EPGMG5.entity;

import be.heh.EPGMG5.Context;
import be.heh.EPGMG5.doubles.InMemoryEmployeeGateway;

public class TestSetup {
    public static void setupContext(){
        Context.employeeGateway = new InMemoryEmployeeGateway();
    }
}
