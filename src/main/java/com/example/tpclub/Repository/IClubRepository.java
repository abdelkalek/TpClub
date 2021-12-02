package com.example.tpclub.Repository;

import com.example.tpclub.Entity.Club;
import com.example.tpclub.Entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IClubRepository extends CrudRepository<Club, Integer> {

    @Query("select c.ref , count(s) as  m from Club c join c.students s GROUP BY c.ref")
    Iterable<String> studentINClub();
    @Query(value = "SELECT c FROM Club c where  c.students.size = (SELECT  max(c.students.size) FROM Club c  )")
    Iterable<Club> bestClub();
    @Query(value = "SELECT c FROM Club c where  c.students.size = (SELECT  min(c.students.size) FROM Club c  )")
    Iterable<Club> worstClub();
    @Query(value = "SELECT c.students  FROM Club c where  c.students.size = (SELECT  min(c.students.size) FROM Club c  )")
    Iterable<Student> bestStudent();
    @Query("from Club c  where :stu in (c.students)")
    Iterable<Club> listclubstudent(@Param("stu") Student stu);
}
