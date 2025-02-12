package com.example.doctorapp.repository;

import com.example.doctorapp.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity,Long> {
    DoctorEntity findByFullName(String fullName);
    DoctorEntity findByEmail(String email);

}