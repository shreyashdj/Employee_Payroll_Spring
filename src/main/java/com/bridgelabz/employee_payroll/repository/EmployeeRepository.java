package com.bridgelabz.employee_payroll.repository;

import com.bridgelabz.employee_payroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository <Employee,Integer> {
    @Query(value = "select * from employee e where e.name = ?",nativeQuery = true)
    List<Employee> findByName(String empName);
    @Query(value = "select * from employee, employee_department where employee_id = id and department = :dept", nativeQuery = true)
    List<Employee> findByDept(String dept);
}