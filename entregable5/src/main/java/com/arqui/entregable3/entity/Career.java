package com.arqui.entregable3.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Career {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private int duration;

    @JsonManagedReference
    @OneToMany(mappedBy = "career",cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<PersonCareer> students;


    public Career(){
        super();
    }

    public Career(Integer id, String name, int duration) {
        this.id=id;
        this.name = name;
        this.duration = duration;
        this.students = new ArrayList<>();
    }
    public Career( String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.students = new ArrayList<>();
    }

    public Career(String s) {
    }


    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoundation() {
        return duration;
    }

    public void setFoundation(int duration) {
        this.duration = duration;
    }

    public List<PersonCareer> getStudents() {
        return students;
    }

    public void setStudents(Person student)
    {
        PersonCareer pc = new PersonCareer(student,this);
        this.students.add(pc);
    }

    @Override
    public String toString() {
        return "Career{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}