package com.arqui.entregable3.repository;

import com.arqui.entregable3.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findBycollegeNotebook(int LU);

    List<Person> findBygender(String gender);


}
