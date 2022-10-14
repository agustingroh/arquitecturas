package com.arqui.entregable3.controller;

import com.arqui.entregable3.dto.PersonDTO;
import com.arqui.entregable3.entity.Person;
import com.arqui.entregable3.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Person> findAll(){
        System.out.println(personService.findAll());
        return personService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public PersonDTO addNewPerson(@RequestBody PersonDTO person){
        System.out.println("POST" + person);
        return personService.addNewPerson(person);
    }
    @RequestMapping(value="/order",method = RequestMethod.GET, produces = "application/json")
    public List<PersonDTO> getAllStudentsBy(@RequestParam("find") String params){
        return personService.getAllStudentsBy(params);
    }

    @RequestMapping(value = "/collegeNotebook/{LU}", method = RequestMethod.GET, produces = "application/json")
    public PersonDTO getStudentByLU(@PathVariable int LU){
        return personService.getStudentByLU(LU);
    }

    @RequestMapping(value = "/gender/{gender}", method = RequestMethod.GET, produces = "application/json")
    public List<PersonDTO> getStudentsByGender(@PathVariable String gender){
        return personService.getStudentsByGender(gender);
    }






}
