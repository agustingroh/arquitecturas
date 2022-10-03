package main.java.entities;

import main.java.repository.PersonCareerRepository;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class PersonCareer {

    @EmbeddedId
    private PersonCareerId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("student_dni")
    @JoinColumn(name = "student_dni")
    private Person student;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("career_id")
    @JoinColumn(name = "career_id",referencedColumnName = "id")
    private  Career career;

    @Column
    private Boolean graduated;

    @Column(nullable = false)
    private Date initDate;

    @Column
    private Date dueDate;


    public PersonCareer(){
        super();
    }

    public PersonCareer(Person student, Career career, Boolean graduated, Date initDate, Date dueDate) {
        super();
        this.student = student;
        this.career = career;
        this.graduated = false;
        this.initDate = new Date();
        this.dueDate = dueDate;
        this.id = new PersonCareerId(student.getDni(),career.getId());

    }

    public PersonCareer(Person student, Career career) {
        super();
        this.student = student;
        this.career = career;
        this.graduated = false;
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

    public Boolean getGraduated() {
        return graduated;
    }

    public void setGraduated(Boolean graduated) {
        this.graduated = graduated;
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
            return "graduation:" + this.graduated;
        }

}
