package com.example.tpclub.Repository;

import com.example.tpclub.Entity.Classroom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IClassroomRepository extends CrudRepository<Classroom, Integer> {
    @Query(value = "SELECT c FROM Classroom c where  c.classuser.size = (SELECT  max(c.students.size) FROM Club c  )")
    Iterable<Classroom> bestClub();
}
