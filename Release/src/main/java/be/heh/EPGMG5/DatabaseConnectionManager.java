package be.heh.EPGMG5;

import java.sql.Connection;
import java.sql.DriverManager;


/*
    docker création:
    docker run -d -p 5432:5432 --name my-postgres -e POSTGRES_PASSWORD=mysecretpassword postgres
    docker exec -it my-postgres bash
    psql -U postgres
    CREATE DATABASE employees;
    \q
    psql -h localhost -p 5432 -U postgres -W
    Password for user postgres: mysecretpassword
    \l

    outils :
    pgadmin
    postman --> pour test les request
    CreateDatabasePayroll --> pour faire les column de la table employee
 */
public class DatabaseConnectionManager {
    public static void main(String args[]) {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/employees",
                            "postgres", "mysecretpassword");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
