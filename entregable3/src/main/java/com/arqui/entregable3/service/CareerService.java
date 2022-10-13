package com.arqui.entregable3.service;

import com.arqui.entregable3.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CareerService {

    private CareerRepository CareerRepository;

    @Autowired
    public CareerService(CareerRepository CareerRepository){
        this.CareerRepository = CareerRepository;
    }
}
