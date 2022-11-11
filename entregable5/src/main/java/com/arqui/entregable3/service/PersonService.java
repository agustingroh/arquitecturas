package com.arqui.entregable3.service;

import com.arqui.entregable3.dto.CareerWithPersonDataDTO;
import com.arqui.entregable3.dto.PersonDTO;
import com.arqui.entregable3.entity.Career;
import com.arqui.entregable3.entity.Person;
import com.arqui.entregable3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
      return personRepository.findAll();

    }

    public PersonDTO addNewPerson(PersonDTO person){
        Person p = new Person(person.getDni(),person.getName(),person.getSurname(),person.getGender(),person.getCity(),person.getCollegeNotebook(),person.getAge());
        personRepository.save(p);
        return person;
    }

    public List<PersonDTO> getAllStudentsBy(String params){
        List<Person> students = personRepository.findAll(Sort.by(Sort.Direction.ASC, params));
        return this.getStudentDTOList(students);
    }

    public PersonDTO getStudentByLU(int LU){
       Person p = this.personRepository.findBycollegeNotebook(LU);
       return new PersonDTO(p.getDni(),p.getName(),p.getSurname(),p.getGender(),p.getCity(),p.getAge(),p.getCollegeNotebook());
    }

    public List<PersonDTO> getStudentsByGender(String gender){
        List<Person> students = this.personRepository.findBygender(gender);
        return getStudentDTOList(students);
    }

    private List<PersonDTO> getStudentDTOList (List<Person> students){
        List<PersonDTO> studentsDTO = new ArrayList<>();
        students.forEach(p ->{
            List<CareerWithPersonDataDTO> careersDTOs = new LinkedList<>();
            p.getCareers().forEach(pc -> {
                Career c = pc.getCareer();
                careersDTOs.add(new CareerWithPersonDataDTO(c.getId(), c.getName(), c.getDuration(), new LinkedList(), pc));
            });
            studentsDTO.add(new PersonDTO(p.getDni(),p.getName(),p.getSurname(),p.getGender(),p.getCity(),p.getAge(),p.getCollegeNotebook(), careersDTOs));
        } );
        return studentsDTO;
    }

}
