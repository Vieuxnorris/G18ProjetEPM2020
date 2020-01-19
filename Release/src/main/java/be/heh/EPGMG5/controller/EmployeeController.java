package be.heh.EPGMG5.controller;

import be.heh.EPGMG5.model.EmployeeModel;
import be.heh.EPGMG5.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.heh.EPGMG5.controller.ResourceNotFoundException;
import be.heh.EPGMG5.model.EmployeeModel;
import be.heh.EPGMG5.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        EmployeeModel employeeModel = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employeeModel);
    }

    @PostMapping("/employee")
    public EmployeeModel createEmployee(@Valid @RequestBody EmployeeModel employeeModel)
    {
        return employeeRepository.save(employeeModel);
    }

    @PutMapping("/employee/{id}")
        public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable(value = "id") Long employeeId, @Valid @RequestBody EmployeeModel employeeDetails) throws ResourceNotFoundException {
        EmployeeModel employeeModel = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("employee not found for this id :: " + employeeId));

        employeeModel.setAddress(employeeDetails.getAddress());
        employeeModel.setName(employeeDetails.getName());
        final EmployeeModel updateEmployee = employeeRepository.save(employeeModel);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/employee/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        EmployeeModel employeeModel = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employeeModel);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
