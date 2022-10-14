package com.arqui.entregable3.service;

import com.arqui.entregable3.dto.InscriptionDTO;
import com.arqui.entregable3.dto.PersonDTO;
import com.arqui.entregable3.entity.Career;
import com.arqui.entregable3.entity.Person;
import com.arqui.entregable3.entity.PersonCareer;
import com.arqui.entregable3.repository.CareerRepository;
import com.arqui.entregable3.repository.PersonCareerRepository;
import com.arqui.entregable3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class PersonCareerService {

    private PersonCareerRepository personCareerRepository;
    private PersonRepository personRepository;
    private CareerRepository careerRepository;

    @Autowired
    public PersonCareerService(PersonCareerRepository PersonCareerRepository,
                               PersonRepository personRepository, CareerRepository careerRepository){
        this.personCareerRepository = PersonCareerRepository;
        this.careerRepository = careerRepository;
        this.personRepository = personRepository;
    }


    public PersonDTO register(InscriptionDTO inscription){
        Person p = personRepository.getById(inscription.getPersonId());
        Career c = careerRepository.getById(inscription.getCareerId());


        this.personCareerRepository.save(new PersonCareer(p,c));
        p = personRepository.getById(inscription.getPersonId());

        List<Career> careers = new ArrayList<>();
        p.getCareers().forEach(personCareer -> {
                careers.add(personCareer.getCareer());
        });


        return new PersonDTO(p.getDni(),p.getName(),p.getSurname(),p.getGender()
                ,p.getCity(),p.getAge(),p.getCollegeNotebook(),careers);

    }
}
