package com.arqui.entregable3.service;

import com.arqui.entregable3.entity.Career;
import com.arqui.entregable3.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerService {

    private CareerRepository careerRepository;

    @Autowired
    public CareerService(CareerRepository CareerRepository){
        this.careerRepository = CareerRepository;
    }

    public List<Career> getAllCareersWithStudents(){
        List<Career> careers = this.careerRepository.getAllCareersWithStudents();
        careers.forEach(career -> {

          career.getStudents().forEach(personCareer -> {
                System.out.println(personCareer.getStudent());
            });
        });
        return careers;
    }
}
