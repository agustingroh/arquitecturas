package com.arqui.entregable3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PersonCareer {

    @EmbeddedId
    private PersonCareerId id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("student_dni")
    @JoinColumn(name = "student_dni")
    private Person student;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("career_id")
    @JoinColumn(name = "career_id",referencedColumnName = "id")
    private  Career career;

    @Column(nullable = false)
    private Date initDate;

    @Column
    private Date dueDate;


    public PersonCareer(){
        super();
    }

    public PersonCareer(Person student, Career career, Date initDate, Date dueDate) {
        super();
        this.student = student;
        this.career = career;
        this.initDate = new Date();
        this.dueDate = dueDate;
        this.id = new PersonCareerId(student.getDni(),career.getId());

    }

    public PersonCareer(Person student, Career career) {
        super();
        this.student = student;
        this.career = career;
        this.initDate = new Date();
        this.dueDate = null;
        this.id = new PersonCareerId(student.getDni(),career.getId());
        System.out.println(id);
    }


    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public Boolean isGraduated() {
        return this.dueDate != null;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public PersonCareerId getId(){
        return this.id;
    }


    @Override
    public String toString() {
        return "initDate:" + this.initDate.toString() + "graduated:" + "" + this.dueDate.toString();
    }

}