package com.arqui.entregable3.repository;

import com.arqui.entregable3.entity.Person;
import com.arqui.entregable3.entity.PersonCareer;
import com.arqui.entregable3.entity.PersonCareerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonCareerRepository extends JpaRepository<PersonCareer, PersonCareerId> {

    @Query(value = "SELECT a.career_id, a.name, a.year ,SUM(a.enrolled) as enrolled,SUM(a.graduated) as graduated FROM (SELECT pc.career_id,c.name, YEAR(pc.initDate) as year, COUNT(*) as enrolled, '0' as graduated FROM PersonCareer pc JOIN Career c ON c.id=pc.career_id GROUP BY pc.career_id,c.name,year UNION SELECT pc.career_id,c.name, YEAR(pc.dueDate) as year,'0' as enrolled ,COUNT(*) as graduated FROM PersonCareer pc JOIN Career c ON c.id=pc.career_id GROUP BY pc.career_id,c.name,year HAVING year IS NOT NULL) as a GROUP BY a.career_id, a.name, a.year ORDER BY a.year ASC, a.name ASC", nativeQuery = true)
    List<Object[]> getReport();

    @Query("SELECT DISTINCT(p) FROM Person p JOIN p.careers pc  WHERE pc.career.id = :careerId AND p.city = :city")
    List<Person> findAllStudentsByCareerAndCity(@Param("careerId") int career,@Param("city") String city);

}
