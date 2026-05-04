package com.example.Proj1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Proj1.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}