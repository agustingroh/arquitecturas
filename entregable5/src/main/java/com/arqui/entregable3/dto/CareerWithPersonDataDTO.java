package com.arqui.entregable3.dto;

import com.arqui.entregable3.entity.PersonCareer;
import org.aspectj.weaver.patterns.PerObject;

import java.util.Date;
import java.util.LinkedList;

public class CareerWithPersonDataDTO extends CareerDTO{
    private Date initDate;
    private Date graduatedDate;
    private boolean graduated;


    public CareerWithPersonDataDTO(Integer id, String name, int duration, LinkedList<PersonDTO> students, PersonCareer pc) {
        super(id, name, duration, students);
        this.initDate = pc.getInitDate();
        this.graduatedDate = pc.getDueDate();
        this.graduated = pc.isGraduated();
    }

    public Date getInitDate() {
        return initDate;
    }

    public Date getGraduatedDate() {
        return graduatedDate;
    }

    public boolean isGraduated() {
        return graduated;
    }
}
