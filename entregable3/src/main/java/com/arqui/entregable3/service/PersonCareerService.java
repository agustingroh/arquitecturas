package com.arqui.entregable3.service;

import com.arqui.entregable3.dto.CareerDTO;
import com.arqui.entregable3.dto.CareerReportDTO;
import com.arqui.entregable3.dto.InscriptionDTO;
import com.arqui.entregable3.dto.PersonDTO;
import com.arqui.entregable3.entity.Career;
import com.arqui.entregable3.entity.Person;
import com.arqui.entregable3.entity.PersonCareer;
import com.arqui.entregable3.repository.CareerRepository;
import com.arqui.entregable3.repository.PersonCareerRepository;
import com.arqui.entregable3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonCareerService {

    private PersonCareerRepository personCareerRepository;
    private PersonRepository personRepository;
    private CareerRepository careerRepository;

    @Autowired
    public PersonCareerService(PersonCareerRepository PersonCareerRepository,
                               PersonRepository personRepository, CareerRepository careerRepository){
        this.personCareerRepository = PersonCareerRepository;
        this.careerRepository = careerRepository;
        this.personRepository = personRepository;
    }


    public PersonDTO register(InscriptionDTO inscription){
        Person p = personRepository.getById(inscription.getPersonId());
        Career c = careerRepository.getById(inscription.getCareerId());
        this.personCareerRepository.save(new PersonCareer(p,c));
        p = personRepository.getById(inscription.getPersonId());

        List<CareerDTO> careers = new ArrayList<>();
        p.getCareers().forEach(personCareer -> {
            Career career =  personCareer.getCareer();
            CareerDTO careerDTO = new CareerDTO(career.getId(),career.getName(),career.getDuration(),new LinkedList<>());
            careers.add(careerDTO);
        });
        return new PersonDTO(p.getDni(),p.getName(),p.getSurname(),p.getGender()
                ,p.getCity(),p.getAge(),p.getCollegeNotebook(),careers);

    }

    public List<CareerReportDTO> getReport(){
        List<Object[]> careerReports = this.personCareerRepository.getReport();
        return careerReports.stream().map(r-> new CareerReportDTO((Integer)r[0],(String) r[1],((BigInteger)r[2]).intValue(),((Double) r[3]).intValue(),((Double) r[4]).intValue())).collect(Collectors.toList());
    }

    public List<PersonDTO> findAllStudentsByCareerAndCity(int careerId, String city){
       List<Person> students = this.personCareerRepository.findAllStudentsByCareerAndCity(careerId,city);
        LinkedList<CareerDTO> careerDTOS = new LinkedList<>();
        LinkedList<PersonDTO> studentDTOS = new LinkedList<>();
        students.forEach(student -> {
            student.getCareers().forEach(personCareer -> {
                Career career = personCareer.getCareer();
                CareerDTO c = new CareerDTO(career.getId(),career.getName(),career.getDuration(),new LinkedList<>());
                careerDTOS.add(c);
            });
            PersonDTO p = new PersonDTO(student.getDni(),student.getName(),student.getSurname(),
                    student.getGender(),student.getCity(),student.getAge(),student.getCollegeNotebook(),careerDTOS);
            studentDTOS.add(p);
        });
        return studentDTOS;
    }
}
