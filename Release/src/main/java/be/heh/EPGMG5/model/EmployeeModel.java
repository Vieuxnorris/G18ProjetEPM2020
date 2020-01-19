package be.heh.EPGMG5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeModel {

    private long id;
    private String name;
    private String address;

    public EmployeeModel()
    {

    }

    public EmployeeModel(String name, String address)
    {
        this.name = name;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString() {
        return "employee [id=" + id + ", name=" + name + ", address=" + address + "]";
    }
}
