package com.arqui.entregable3.dto;

public class PersonDTO {
    private Integer dni;

    private String name;

    private String surname;

    private String gender;

    private String city;

    private int age;

    public int collegeNotebook;

    public PersonDTO(Integer dni, String name, String surname, String gender, String city, int age, int collegeNotebook) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.city = city;
        this.age = age;
        this.collegeNotebook = collegeNotebook;
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
}
