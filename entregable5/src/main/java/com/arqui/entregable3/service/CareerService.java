package com.arqui.entregable3.service;

import com.arqui.entregable3.dto.CareerDTO;
import com.arqui.entregable3.dto.PersonDTO;
import com.arqui.entregable3.entity.Career;
import com.arqui.entregable3.entity.Person;
import com.arqui.entregable3.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CareerService {

    private CareerRepository careerRepository;

    @Autowired
    public CareerService(CareerRepository CareerRepository){
        this.careerRepository = CareerRepository;
    }

    public List<CareerDTO> getAllCareersWithStudents(){
        List<Career> careers = this.careerRepository.getAllCareersWithStudents();
        LinkedList<CareerDTO> careerDTOS =  new LinkedList<>();

        careers.forEach(career -> {
               LinkedList<PersonDTO> students = new LinkedList<>();
          career.getStudents().forEach(personCareer -> {
              Person person = personCareer.getStudent();
              PersonDTO personDTO = new PersonDTO(person.getDni(),person.getName(),person.getSurname()
                      ,person.getGender(),person.getCity(),person.getAge(),person.getCollegeNotebook());
                students.add(personDTO);
            });
            CareerDTO c = new CareerDTO(career.getId(),career.getName(),career.getDuration(),students);
            careerDTOS.add(c);
        });
        return careerDTOS;
    }
}
