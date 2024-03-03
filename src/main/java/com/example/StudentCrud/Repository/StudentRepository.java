package com.example.StudentCrud.Repository;

import com.example.StudentCrud.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
