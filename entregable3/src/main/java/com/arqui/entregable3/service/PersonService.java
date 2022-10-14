package com.arqui.entregable3.service;

import com.arqui.entregable3.dto.PersonDTO;
import com.arqui.entregable3.entity.Person;
import com.arqui.entregable3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
      return personRepository.findAll();

    }

    public PersonDTO addNewPerson(PersonDTO person){
        Person p = new Person(person.getDni(),person.getName(),person.getSurname(),person.getGender(),person.getCity(),person.getCollegeNotebook(),person.getAge());
        personRepository.save(p);
        return person;
    }


}
