package com.SpringREST.studentCRUDdemo.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequest {
    @NotNull(message = "Student ID is mandatory")
    private Long studentId;

    @NotNull(message = "Student DOB is mandatory")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate studentDob;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public LocalDate getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(LocalDate studentDob) {
        this.studentDob = studentDob;
    }
}
