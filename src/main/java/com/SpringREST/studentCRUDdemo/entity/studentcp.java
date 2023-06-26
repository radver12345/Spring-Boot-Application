package com.SpringREST.studentCRUDdemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public class studentcp {

    @NotNull
    private String student_dob;
    @NotNull
    @Size(max = 50)
    private String student_Name;
    @NotNull
    @Size(max = 50)
    private String school_name;
    @NotNull
    @Size(max = 100)
    private String School_address;
    private int attendence;


    private List<MarksRes> marks;

    public studentcp(String student_dob, String student_Name, String school_name, String school_address, int attendence, List<MarksRes> marks) {
        this.student_dob = student_dob;
        this.student_Name = student_Name;
        this.school_name = school_name;
        School_address = school_address;
        this.attendence = attendence;
        this.marks = marks;
    }

    public String getStudent_dob() {
        return student_dob;
    }

    public void setStudent_dob(String student_dob) {
        this.student_dob = student_dob;
    }

    public String getStudent_Name() {
        return student_Name;
    }

    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_address() {
        return School_address;
    }

    public void setSchool_address(String school_address) {
        School_address = school_address;
    }

    public int getAttendence() {
        return attendence;
    }

    public void setAttendence(int attendence) {
        this.attendence = attendence;
    }

    public List<MarksRes> getMarks() {
        return marks;
    }

    public void setMarks(List<MarksRes> marks) {
        this.marks = marks;
    }
}
