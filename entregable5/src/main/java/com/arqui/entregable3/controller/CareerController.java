package com.arqui.entregable3.controller;

import com.arqui.entregable3.dto.CareerDTO;
import com.arqui.entregable3.dto.PersonDTO;
import com.arqui.entregable3.entity.Career;
import com.arqui.entregable3.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/career")
public class CareerController {

    private CareerService careerService;

    @Autowired
    public CareerController(CareerService CareerService){
        this.careerService = CareerService;
    }

    @RequestMapping(value = "/inscriptions",method = RequestMethod.GET, produces = "application/json")
    public List<CareerDTO> findAlCareersWithStudents(){
      return  careerService.getAllCareersWithStudents();
    }



}
