package com.SpringREST.studentCRUDdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public class StudentResults  {
    private Student student;

    private List<MarksRes> marks;
    private double grandtotal;
    private double percentage;
    private String grade;

    public StudentResults() {
    }

    public StudentResults(Student student, List<MarksRes> marks, double grandtotal, double percentage, String grade) {
        this.student = student;
        this.marks = marks;
        this.grandtotal = grandtotal;
        this.percentage = percentage;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<MarksRes> getMarks() {
        return marks;
    }

    public void setMarks(List<MarksRes> marks) {
        this.marks = marks;
    }

    public double getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(double grandtotal) {
        this.grandtotal = grandtotal;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


}
