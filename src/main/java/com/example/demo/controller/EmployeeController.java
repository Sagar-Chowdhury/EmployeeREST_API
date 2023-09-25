package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    //Injecting the service
    private EmployeeService employeeService;

    // Add CRUD
      @PostMapping
      public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto )
      {
          EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
          return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
      }

      @GetMapping("{id}")
      public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id)
      {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);

      }

      @GetMapping
      public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
          List<EmployeeDto> employees = employeeService.getAllEmployees();
          return ResponseEntity.ok(employees);
      }

      @PutMapping("{id}")
      public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId ,@RequestBody EmployeeDto updatedEmployee)
      {
          EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
          return ResponseEntity.ok(employeeDto);
      }

      @DeleteMapping("{id}")
      public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId)
      {
         employeeService.deleteEmployee(employeeId);
         return ResponseEntity.ok("Employee Deleted suceessfully");
      }




}
