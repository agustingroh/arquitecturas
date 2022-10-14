package com.arqui.entregable3.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Person {
    @Id
    @Column(name = "dni")
    public Integer dni;

    @Column(name = "name")
    public String name;

    public String surname;

    public String gender;

    public String city;

    public int age;

    @Column(name="college_notebook")
    public int collegeNotebook;

    @JsonManagedReference
    @OneToMany(mappedBy = "student", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<PersonCareer> careers;

    public Person(){
        super();
    }

    public Person(Integer dni, String name, String surname, String gender, String city, int collegeNotebook, int age) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.city = city;
        this.collegeNotebook = collegeNotebook;
        this.careers = new ArrayList<>();
        this.age = age;
    }

    public Person(String s) {
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCollegeNotebook() {
        return collegeNotebook;
    }

    public void setCollegeNotebook(int collegeNotebook) {
        this.collegeNotebook = collegeNotebook;
    }

 /*   public List<PersonCareer> getCareers() {
        return careers;
    }*/

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){return this.age;}
    public void setCareers(Career c)
    {
        PersonCareer pc = new PersonCareer(this,c);
        this.careers.add(pc);
        c.setStudents(this);

    }

    @Override
    public String toString() {
        return      "{" + "dni=" + dni +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", age='" + age + '\'' +
                ", collegeNotebook=" + collegeNotebook +
                '}';
    }
}
