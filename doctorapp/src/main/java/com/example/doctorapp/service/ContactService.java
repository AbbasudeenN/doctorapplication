package com.example.doctorapp.service;

import com.example.doctorapp.entity.ContactEntity;
import com.example.doctorapp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactEntity saveContact(ContactEntity contactEntity){
        return contactRepository.save(contactEntity);
    }
}
