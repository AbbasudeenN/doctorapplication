package com.example.doctorapp.service;

import com.example.doctorapp.entity.DoctorEntity;
import com.example.doctorapp.entity.UserEntity;
import com.example.doctorapp.repository.DoctorRepository;
import com.example.doctorapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Register Doctor
    public DoctorEntity registerDoctor(DoctorEntity doctor) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFullName(doctor.getFullName());
        userEntity.setEmail(doctor.getEmail());
        userEntity.setPassword(passwordEncoder.encode(doctor.getPassword())); // Encrypting the password
        userEntity.setRole("ROLE_DOCTOR");
        userRepository.save(userEntity);
        return doctorRepository.save(doctor);
    }

    // Get All Doctors
    public List<DoctorEntity> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Get Doctor by ID
    public Optional<DoctorEntity> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    // Update Doctor by ID
    public DoctorEntity updateDoctorById(Long id, DoctorEntity doctor) {
        Optional<DoctorEntity> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            DoctorEntity doctorEntity = optionalDoctor.get();
            updateDoctorEntity(doctorEntity, doctor);
            return doctorRepository.save(doctorEntity);
        } else {
            throw new IllegalArgumentException("Doctor not found for ID: " + id);
        }
    }

    // Helper method to update DoctorEntity fields
    private void updateDoctorEntity(DoctorEntity doctorEntity, DoctorEntity doctor) {
        doctorEntity.setFullName(doctor.getFullName());
        doctorEntity.setEmail(doctor.getEmail());
        doctorEntity.setPassword(passwordEncoder.encode(doctor.getPassword())); // Encrypting the password
        doctorEntity.setAge(doctor.getAge());
        doctorEntity.setGender(doctor.getGender());
        doctorEntity.setQualification(doctor.getQualification());
        doctorEntity.setSpecialist(doctor.getSpecialist());
        doctorEntity.setPhone(doctor.getPhone());
        doctorEntity.setFee(doctor.getFee());
    }

    // Delete Doctor by ID
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    // Count Total Doctor
    public long countTotalDoctor() {
        return doctorRepository.count();
    }

    // Find Doctor by Full Name
    public DoctorEntity findDoctorByFullName(String fullName) {
        return doctorRepository.findByFullName(fullName);
    }

    // Find Doctor by Email
    public DoctorEntity findDoctorByEmail(String email) {
        return doctorRepository.findByEmail(email);
    }

    // Count Total Appointment for a Specific Doctor
//    public long countTotalAppointmentByDoctorId(Long id) {
//        return doctorRepository.countAppointmentsByDoctorId(id);
//    }
}
