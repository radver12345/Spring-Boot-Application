package com.SpringREST.studentCRUDdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Entity
@Table(name="marks")
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="m_id")
    private int id;

    @Column(name="sub_code")
    private String subjectCode;

    @Column(name="sub_name")
    private String subjectName;

    @Column(name = "max_marks")
    private double maxMarks;

    @Column(name="obtained_marks")
    private double obtainedMarks;

    @Column(name = "sub_grade")
    private String subGrade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;


}
