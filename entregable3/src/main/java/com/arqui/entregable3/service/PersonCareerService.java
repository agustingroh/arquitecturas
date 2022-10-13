package com.arqui.entregable3.service;

import com.arqui.entregable3.repository.PersonCareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonCareerService {

    private PersonCareerRepository PersonCareerRepository;

    @Autowired
    public PersonCareerService(PersonCareerRepository PersonCareerRepository){
        this.PersonCareerRepository = PersonCareerRepository;
    }
}
