package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.exception.EmployeeException;
import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll.entity.Employee;
import com.bridgelabz.employee_payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    EmployeeRepository employeeRepo;
    @Override
    public List<Employee> getAllEmployeePayrollData() {
        if (employeeRepo.findAll().isEmpty()){
            throw new EmployeeException("No employee found in database");
        } else {
            return employeeRepo.findAll();
        }
    }

    @Override
    public Employee getEmployeePayrollDataById(int empId) {
            return employeeRepo.findById(empId).orElseThrow(() -> new EmployeeException("Employee not found for id '" + empId + "'"));
    }

    @Override
    public Employee addEmployeePayrollData(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO) {
        if (employeeRepo.findById(empId).isPresent()){
            Employee employee = new Employee(employeeDTO);
            employee.setEmployeeId(empId);
            return employeeRepo.save(employee);
        } else {
            throw new EmployeeException("Employee not found for id '" + empId + "'");
        }
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        if (employeeRepo.findById(empId).isPresent()){
            employeeRepo.deleteById(empId);
        } else {
            throw new EmployeeException("Employee not found for id '" + empId + "'");
        }
    }

    public List<Employee> getEmployeeDataByName(String employeeName) {
        if (employeeRepo.findByName(employeeName).isEmpty()){
            throw new EmployeeException("Employees not found for name '" + employeeName + "'");
        } else {
            return employeeRepo.findByName(employeeName);
        }
    }

    public List<Employee> getEmployeeDataByDepartment(String dept) {
        if (employeeRepo.findByDept(dept).isEmpty()){
            throw new EmployeeException("Employees not found for department '" + dept + "'");
        } else {
            return employeeRepo.findByDept(dept);
        }
    }
}