package com.SpringREST.studentCRUDdemo.repository;

import com.SpringREST.studentCRUDdemo.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksRepository extends JpaRepository<Marks,Integer> {
     List<Marks> findByStudentId(int studentId);


}
