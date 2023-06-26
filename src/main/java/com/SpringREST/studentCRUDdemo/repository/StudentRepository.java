package com.SpringREST.studentCRUDdemo.repository;

import com.SpringREST.studentCRUDdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
//    Optional<Student> findById(int id);
//    static Optional<Object> findByIdAndStudentDOB(int id, String student_dob);
//Optional<Student> findByStudentIdAndStudentDob(Integer studentId, LocalDate studentDob);

}
