package com.bridgelabz.employee_payroll.controller;

import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll.dto.ResponseDTO;
import com.bridgelabz.employee_payroll.entity.Employee;
import com.bridgelabz.employee_payroll.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee-payroll")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping("getAll")
    public ResponseEntity<ResponseDTO> getAllEmployeePayrollData(){
        List<Employee> employeeList = employeeService.getAllEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", employeeList);
        return  new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("getById/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable int empId){
        Employee empById = employeeService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call by Id Success", empById);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("getByName/{empName}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataByName(@PathVariable("empName") String empName) {
        List<Employee> empList = employeeService.getEmployeeDataByName(empName);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for employee by name Successful", empList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("getByDept/{dept}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataByDepartment(@PathVariable("dept") String dept) {
        List<Employee> empList = employeeService.getEmployeeDataByDepartment(dept);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for employee by department Successful", empList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("add")
    public ResponseEntity<ResponseDTO> addEmployeePayroll(@Valid @RequestBody EmployeeDTO employeeDTO){
        Employee employeeData = employeeService.addEmployeePayrollData(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added Employee Payroll Data Successfully",employeeData);
        return  new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }
    @PutMapping("update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@PathVariable("empId") int empId, @Valid @RequestBody EmployeeDTO employeeDTO){
        Employee employeeData = employeeService.updateEmployeePayrollData(empId,employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data Successfully",employeeData);
        return  new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayroll(@PathVariable int empId){
        employeeService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted successfully", empId);
        return  new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}