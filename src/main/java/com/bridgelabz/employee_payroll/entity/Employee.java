package com.bridgelabz.employee_payroll.entity;

import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String name;
    private int salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;

    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.startDate = employeeDTO.getStartDate();
        this.note = employeeDTO.getNote();
        this.profilePic = employeeDTO.getProfilePic();
        this.departments = employeeDTO.getDepartments();
    }

}