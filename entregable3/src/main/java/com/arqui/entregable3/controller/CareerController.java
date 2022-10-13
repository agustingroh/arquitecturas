package com.arqui.entregable3.controller;

import com.arqui.entregable3.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/career")
public class CareerController {

    private CareerService CareerService;

    @Autowired
    public CareerController(CareerService CareerService){
        this.CareerService = CareerService;
    }
}
