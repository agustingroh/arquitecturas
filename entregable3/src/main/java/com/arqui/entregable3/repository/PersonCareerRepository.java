package com.arqui.entregable3.repository;

import com.arqui.entregable3.entity.PersonCareer;
import com.arqui.entregable3.entity.PersonCareerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCareerRepository extends JpaRepository<PersonCareer, PersonCareerId> {
}
