package com.arqui.entregable3.controller;

import com.arqui.entregable3.service.PersonCareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personCareer")
public class PersonCareerController {

    private PersonCareerService PersonCareerService;

    @Autowired
    public PersonCareerController(PersonCareerService PersonCareerService){
        this.PersonCareerService = PersonCareerService;
    }
}
