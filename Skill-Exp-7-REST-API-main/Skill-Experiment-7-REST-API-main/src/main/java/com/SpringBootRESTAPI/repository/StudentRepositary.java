package com.SpringBootRESTAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootRESTAPI.entity.Student;

public interface StudentRepositary extends JpaRepository<Student, Integer> {

}
