package com.arqui.entregable3.controller;

import com.arqui.entregable3.dto.CareerReportDTO;
import com.arqui.entregable3.dto.InscriptionDTO;
import com.arqui.entregable3.dto.PersonDTO;
import com.arqui.entregable3.entity.Person;
import com.arqui.entregable3.service.PersonCareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personCareer")
public class PersonCareerController {

    private PersonCareerService personCareerService;

    @Autowired
    public PersonCareerController(PersonCareerService PersonCareerService){
        this.personCareerService = PersonCareerService;
    }
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public PersonDTO addNewPerson(@RequestBody InscriptionDTO inscription){
        return personCareerService.register(inscription);
    }

    @RequestMapping(value ="/report",method = RequestMethod.GET, produces = "application/json")
    public List<CareerReportDTO> getReport(){
        return this.personCareerService.getReport();
    }

    @RequestMapping(value="/{career}/{city}", method = RequestMethod.GET, produces = "application/json")
    public List<PersonDTO> getStudentsByCareerAndCity(@PathVariable int career, @PathVariable String city){
        return this.personCareerService.findAllStudentsByCareerAndCity(career,city);
    }
}
