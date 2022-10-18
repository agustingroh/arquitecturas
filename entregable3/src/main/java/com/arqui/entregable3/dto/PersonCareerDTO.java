package com.arqui.entregable3.dto;

import java.util.Date;

public class PersonCareerDTO {
    private Date initDate;
    private Date graduatedDate;
    private boolean graduated;

    public PersonCareerDTO(Date initDate, Date graduatedDate, boolean graduated) {
        this.initDate = initDate;
        this.graduatedDate = graduatedDate;
        this.graduated = graduated;
    }

    @Override
    public String toString() {
        return "PersonCareerDTO{" +
                "initDate=" + initDate +
                ", graduatedDate=" + graduatedDate +
                ", graduated=" + graduated +
                '}';
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
