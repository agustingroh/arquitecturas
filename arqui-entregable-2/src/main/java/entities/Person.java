package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    @Column(name = "dni")
    private int dni;

    @Column(name = "name")
    private String name;


    public Person(int dni,String name){
        this.dni = dni;
        this.name = name;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "dni=" + dni +
                ", name='" + name + '\'' +
                '}';
    }
}
