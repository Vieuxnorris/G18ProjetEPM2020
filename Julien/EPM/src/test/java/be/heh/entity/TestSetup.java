package be.heh.entity;

import be.heh.Context;
import be.heh.doubles.InMemoryEmployeeGateway;

import be.heh.doubles.InMemoryEmployeeGateway;
import org.junit.Test;

public class TestSetup {
    public static void setupContext(){
        Context.employeeGateway = new InMemoryEmployeeGateway();
    }
}
