package be.heh.EPGMG5.entity;

import be.heh.EPGMG5.Epgmg5Application;
import be.heh.EPGMG5.model.EmployeeModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
//permet d'exécuter des tests JUnit5 avec n'importe quel autre environnement jUnit plus ancien
@RunWith(SpringRunner.class)
// RANDOM_PORT permet de faire fonctionné les test en même temps que Epgmg5Application (comme un une deuxième app idé)
@SpringBootTest(classes = Epgmg5Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTest {
    // injection de la dépendances
    @Autowired
    private TestRestTemplate restTemplate;

    // injecte le port HTTP alloué lors de l'exécution, ici avec RANDOM_PORT un port libre non alloué par l'app EPGMG5
    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testGetAllEmployees() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "employees/employee", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetEmployeeById() {
        EmployeeModel employeeModel = restTemplate.getForObject(getRootUrl() + "employees/employee/1", EmployeeModel.class);
        System.out.println(employeeModel.getName());
        assertNotNull(employeeModel);
    }

    @Test
    public void testCreateEmployee() {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setName("admin");
        employeeModel.setAddress("admin");
        ResponseEntity<EmployeeModel> postResponse = restTemplate.postForEntity(getRootUrl() + "employees/employee", employeeModel, EmployeeModel.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateEmployee() {
        int id = 1;
        EmployeeModel employeeModel = restTemplate.getForObject(getRootUrl() + "employees/employee/" + id, EmployeeModel.class);
        employeeModel.setName("admin2");
        employeeModel.setAddress("admin2");
        restTemplate.put(getRootUrl() + "employees/employee/" + id, employeeModel);
        EmployeeModel updatedEmployee = restTemplate.getForObject(getRootUrl() + "employees/employee/" + id, EmployeeModel.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        EmployeeModel employeeModel = restTemplate.getForObject(getRootUrl() + "employees/employee/" + id, EmployeeModel.class);
        assertNotNull(employeeModel);
        restTemplate.delete(getRootUrl() + "employees/employee/" + id);
        try {
            employeeModel = restTemplate.getForObject(getRootUrl() + "employees/employee/" + id, EmployeeModel.class);
        } catch (final HttpClientErrorException e) {
            assertNotNull(e.getStatusCode(), String.valueOf(HttpStatus.NOT_FOUND));
        }
    }
}
