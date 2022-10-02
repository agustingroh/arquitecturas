package main.java.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private int duration;


    @OneToMany(mappedBy = "career",cascade = CascadeType.MERGE)
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


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Career{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", students=" + students +
                '}';
    }

    public void setId(int id) {
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
}
