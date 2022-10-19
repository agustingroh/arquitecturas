package com.arqui.entregable3.dto;

import com.arqui.entregable3.entity.Career;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PersonDTO {
    private Integer dni;

    private String name;

    private String surname;

    private String gender;

    private String city;

    private int age;

    private int collegeNotebook;

    private List<CareerWithPersonDataDTO> careers;

    public PersonDTO(){
        this.careers = new LinkedList<>();
    }

    public PersonDTO(Integer dni, String name, String surname, String gender, String city, int age, int collegeNotebook) {
        this();
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.city = city;
        this.age = age;
        this.collegeNotebook = collegeNotebook;
    }

    public PersonDTO(Integer dni, String name, String surname, String gender, String city, int age, int collegeNotebook, List<CareerWithPersonDataDTO> c){
        this(dni,name,surname,gender,city,age,collegeNotebook);
        this.careers = new LinkedList<>();
        this.careers = c;
    }

    public Integer getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public int getCollegeNotebook() {
        return collegeNotebook;
    }

    public List<CareerWithPersonDataDTO> getCareers(){
        return this.careers;
    }

}
