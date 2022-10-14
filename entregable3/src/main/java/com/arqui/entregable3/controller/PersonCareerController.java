package com.arqui.entregable3.controller;

import com.arqui.entregable3.dto.InscriptionDTO;
import com.arqui.entregable3.dto.PersonDTO;
import com.arqui.entregable3.service.PersonCareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personCareer")
public class PersonCareerController {

    private PersonCareerService personCareerService;

    @Autowired
    public PersonCareerController(PersonCareerService PersonCareerService){
        this.personCareerService = PersonCareerService;
    }
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public void addNewPerson(@RequestBody InscriptionDTO inscription){
        personCareerService.register(inscription);
    }
}
