package main.java.dto;

import java.math.BigInteger;
import java.util.Date;

public class CareerDTO {
    private Integer career_id;
    private String name;
    private BigInteger year;
    private int enrolled;
    private int graduated;

    public CareerDTO(Integer career_id, String name, BigInteger year, int enrolled, int graduated) {
        this.career_id = career_id;
        this.name = name;
        this.year = year;
        this.enrolled = enrolled;
        this.graduated = graduated;
    }


    public Integer getCareer_id() {
        return career_id;
    }

    public String getName() {
        return name;
    }

    public BigInteger getYear() {
        return year;
    }

    public int getEnrolled() {
        return enrolled;
    }

    @Override
    public String toString() {
        return "CareerDTO{" +
                "career_id=" + career_id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", enrolled=" + enrolled +
                ", graduated=" + graduated +
                '}';
    }

    public int getGraduated() {
        return graduated;
    }
}
