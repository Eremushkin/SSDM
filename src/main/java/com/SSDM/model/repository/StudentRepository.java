package com.SSDM.model.repository;

import com.SSDM.model.entity.Student;
import org.hibernate.type.SerializableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, Serializable {}
