package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.StudentDTO;


public interface StudentRepository extends JpaRepository<StudentDTO, Integer> {
}
