package com.SpringREST.studentCRUDdemo.entity;


import jakarta.annotation.Resource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.rest.core.annotation.RestResource;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name="student")
public class Student {
   @Id
    private int id;

   @Column(name="student_dob")
    private String student_dob;
   @Column(name="student_name")
    private String student_Name;
   @Column(name="school_name")
    private String school_name;
   @Column(name="school_address")
    private String School_address;
   @Column(name="attendence")
   private int attendence;

    @OneToMany(targetEntity = Marks.class,cascade = CascadeType.ALL)
    @JoinColumn(name="student_id",referencedColumnName = "id")
    @RestResource(exported = false)
    private List<Marks> marks;




}
