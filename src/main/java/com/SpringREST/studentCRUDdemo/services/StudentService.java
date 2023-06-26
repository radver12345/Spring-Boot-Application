package com.SpringREST.studentCRUDdemo.services;

import com.SpringREST.studentCRUDdemo.Dto.StudentRequest;
import com.SpringREST.studentCRUDdemo.entity.Marks;
import com.SpringREST.studentCRUDdemo.entity.MarksRes;
import com.SpringREST.studentCRUDdemo.entity.Student;
import com.SpringREST.studentCRUDdemo.entity.StudentResults;
import com.SpringREST.studentCRUDdemo.repository.MarksRepository;
import com.SpringREST.studentCRUDdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.*;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MarksRepository marksRepository;

    public StudentResults getStudentResults(Integer studentId) {
        Student student=(Student) studentRepository.findById(studentId).orElse(null);
        List<Marks> subjects = marksRepository.findByStudentId(studentId);

        System.out.println(subjects.size());
        double grandTotal = subjects.stream().mapToDouble(Marks::getObtainedMarks).sum();
        double percentage = ((double) grandTotal / 500 ) * 100;
        String overallGrade = calculateOverallGrade(percentage);
        List<MarksRes> ms=new ArrayList<>();
        for(Marks mk:subjects){
            MarksRes mkx=new MarksRes(mk.getId(),mk.getSubjectCode(),mk.getSubjectName(),mk.getMaxMarks(),mk.getObtainedMarks(),mk.getSubGrade());
            ms.add(mkx);
        }

        StudentResults stt= new StudentResults(student,ms,grandTotal,percentage,overallGrade);

        System.out.println(stt.toString());

        return stt;
    }

    private String calculateOverallGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A-";
        } else if (percentage >= 70) {
            return "B+";
        } else if (percentage >= 60) {
            return "B-";
        } else if (percentage >= 50) {
            return "C+";
        } else if (percentage >= 40) {
            return "C-";
        } else {
            return "Fail";
        }
    }

    public void addSubjectMarks(Integer studentId, List<Marks> marks) {


        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setMarks(marks);
            studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found");
        }
    }
    public int verify(Map<String ,Object>rq){
        if(!rq.containsKey("studentId")){
            return -1;
        }
        if(!rq.containsKey("studentDOB")){
        return -1;
        }
        return 1;

    }
    public boolean validateStudent(int studentId, String dob) {
        Optional<Object> student = Optional.of(studentRepository.findById(studentId));
        if (student == null) {

            return false;
        }
        return true;
    }

}
