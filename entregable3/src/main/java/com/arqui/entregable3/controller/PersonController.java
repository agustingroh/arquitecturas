package com.arqui.entregable3.controller;

import com.arqui.entregable3.entity.Person;
import com.arqui.entregable3.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
        return personService.findAll();
    }

}
