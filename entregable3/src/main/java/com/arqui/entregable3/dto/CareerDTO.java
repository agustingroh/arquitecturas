package com.arqui.entregable3.dto;

import javax.persistence.Column;
import java.util.LinkedList;

public class CareerDTO {

    private Integer id;

    private String name;

    private int duration;

    private LinkedList<PersonDTO> students;

    public CareerDTO(Integer id, String name, int duration, LinkedList<PersonDTO> students) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.students = new LinkedList<>();
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public LinkedList<PersonDTO> getStudents() {
        return students;
    }
}
