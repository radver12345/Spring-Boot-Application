package com.SpringREST.studentCRUDdemo.controller;

import com.SpringREST.studentCRUDdemo.entity.Marks;

import com.SpringREST.studentCRUDdemo.entity.Error;
import com.SpringREST.studentCRUDdemo.entity.StudentResults;
import com.SpringREST.studentCRUDdemo.services.StudentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MarksController {
    @Autowired
    private StudentService studentService;


    @PostMapping("/students/results")
    public String getStudentResults(@RequestBody Map<String, Object> request, Model model) {

        int studentId = (int) request.get("id");
        String dob = (String) request.get("student_dob");
        boolean isValid = studentService.validateStudent(studentId, dob);

        if (!isValid) {
            Error er = new Error("Invalid student ID or date of birth.");
            model.addAttribute("error", er);
            return "error";
        }

        StudentResults results = studentService.getStudentResults(studentId);

        if (results.getStudent() == null || !results.getStudent().getStudent_dob().equals(dob)) {
            Error er = new Error("THERE IS NO STUDENT WITH THE ID  " + studentId + "  AND DOB  " + dob);
            model.addAttribute("error", er);
            return "error";
        }
        model.addAttribute("results", results);
        return "results";
    }
}
