package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployeePayrollData();
    Employee getEmployeePayrollDataById(int empId);
    Employee addEmployeePayrollData(EmployeeDTO employeeDTO);
    Employee updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO);
    void deleteEmployeePayrollData(int empId);
    List<Employee> getEmployeeDataByName(String employeeName);
    List<Employee> getEmployeeDataByDepartment(String dept);
}