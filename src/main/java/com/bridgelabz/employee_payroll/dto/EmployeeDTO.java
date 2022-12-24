package com.bridgelabz.employee_payroll.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @NotBlank(message = "Please enter Name")
    @Pattern(regexp="^[A-Z][a-zA-Z]{2,}$", message = "Name should contain min 3 char and 1st char Capital")
    private String name;
    @NotNull(message = "Please enter salary")
    @Min(value = 10000,message = "min 10000 required")
    @Max(value = 40000, message = "max 40000 required")
    private int salary;
    @NotNull(message = "gender can not be null")
    @Pattern(regexp = "^(?:M|F|O)$", message = "Please enter gender as M for male or F female or O for other")
    private String gender;
    @PastOrPresent(message = "Enter Correct Date")
    private LocalDate startDate;
    @NotNull(message = "Please enter Note")
    private String note;
    @NotEmpty(message = "Please enter Department")
    private List<String> department;
    private String profilePic;
}