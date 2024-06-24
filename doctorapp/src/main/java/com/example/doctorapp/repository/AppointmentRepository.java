package com.example.doctorapp.repository;

import com.example.doctorapp.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity,Long> {

    long countByDoctorId(Long doctorId);

    AppointmentEntity findByFullName(String fullName);

    AppointmentEntity findByDoctorId(Long doctorId);

}