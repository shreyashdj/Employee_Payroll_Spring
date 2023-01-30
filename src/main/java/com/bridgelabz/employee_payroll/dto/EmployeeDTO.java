package com.bridgelabz.employee_payroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @NotBlank(message = "Please enter Name")
    @Pattern(regexp="^[A-Z][a-zA-Z\\s]{2,}$", message = "Name should contain min 3 char and 1st char Capital")
    private String name;
    @NotNull(message = "Please enter salary")
    @Min(value = 10000,message = "min 10000 required")
    @Max(value = 100000, message = "max 100000 required")
    private int salary;
    @NotNull(message = "gender can not be null")
    private String gender;
    @PastOrPresent(message = "Enter Correct Date")
    private LocalDate startDate;
    @NotNull(message = "Please enter Note")
    private String note;
    @NotEmpty(message = "Please enter Department")
    private List<String> departments;
    private String profilePic;
}