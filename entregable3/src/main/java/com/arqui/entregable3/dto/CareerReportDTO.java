package com.arqui.entregable3.dto;

public class CareerReportDTO {
    private int id;
    private int enrolled;
    private int graduated;
    private String name;
    private int years;

    public CareerReportDTO(int id, String name, int years, int enrolled, int graduated) {
        this.id = id;
        this.enrolled = enrolled;
        this.graduated = graduated;
        this.name = name;
        this.years = years;
    }

    public int getId() {
        return id;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public int getGraduated() {
        return graduated;
    }

    public String getName() {
        return name;
    }

    public int getYears() {
        return years;
    }
}
