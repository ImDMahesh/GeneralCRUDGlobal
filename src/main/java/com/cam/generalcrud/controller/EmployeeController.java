package com.cam.generalcrud.controller;

import com.cam.generalcrud.bean.Employee;
import com.cam.generalcrud.service.EmployeeService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp")
    @Operation(
            tags = {"Employee Operations"}
    )
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = employeeService.fetchAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping("/emp/save")
    @Operation(
            tags = {"Employee Operations"}
    )
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PostMapping("/emp")
    @Operation(
            tags = {"Employee Operations"}
    )
    //http://localhost:8080/api/v1/emp?employeeID=2
    public ResponseEntity<?> getEmployeeByID(@RequestParam Long employeeID) {
        Employee retrievedEmployee = employeeService.getEmployeeByID(employeeID);
        return new ResponseEntity<>(retrievedEmployee, HttpStatus.OK);
    }

   /* PathVariable example
   @PostMapping("/emp/{employeeID}")
    //http://localhost:8080/api/v1/emp/2
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable Long employeeID) {
        Employee retrievedEmployee = employeeService.getEmployeeByID(employeeID);
        return new ResponseEntity<>(retrievedEmployee, HttpStatus.OK);
    }*/

    @DeleteMapping("/emp")
    @Operation(
            tags = {"Employee Operations", "Employee Operation2"},
            operationId = "Delete Employee",
            summary = "Delete Employee",
            description = "This is Delete operation on employee",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "This is the request body desc",
                    content = @Content(schema = @Schema(implementation = Employee.class))),
            parameters = {@Parameter(name = "employeeID", description = "This is the request parameter", example = "2", in = ParameterIn.QUERY)},
            externalDocs = @ExternalDocumentation(url = "https://onetoone.com/desc", description = "For more details please check"),
            responses = {@ApiResponse(responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Employee.class), mediaType = MediaType.APPLICATION_JSON_VALUE, examples = {@ExampleObject(name = "Success 1", value = "Object"), @ExampleObject(name = "Success 2", value = "String")}), description = "Success Response")},
            security = {@SecurityRequirement(name="BearerJWT")}
    )
    public ResponseEntity<?> deleteEmployeeByID(@RequestParam Long employeeID) {

        employeeService.deleteEmployeeByID(employeeID);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/emp/update")
    @Operation(
            tags = {"Employee Operations"}
    )
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.CREATED);
    }

}
