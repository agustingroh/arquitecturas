package com.arqui.entregable3.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonCareerId implements Serializable {


    @Column(name = "student_id")
    private Integer student_dni;

    @Column(name = "career_id")
    private Integer career_id;

    public PersonCareerId() {}

    public PersonCareerId(
            Integer student_dni,
            Integer career_id) {
        this.student_dni = student_dni;
        this.career_id = career_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonCareerId that = (PersonCareerId) o;
        return student_dni == that.student_dni && career_id == that.career_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_dni, career_id);
    }


    @Override
    public String toString() {
        return "PersonCareerId[" +
                "student_dni=" + student_dni +
                ", career_id=" + career_id +
                '}';
    }
}