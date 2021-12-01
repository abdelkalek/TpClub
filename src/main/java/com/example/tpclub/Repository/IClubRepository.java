package com.example.tpclub.Repository;

import com.example.tpclub.Entity.Club;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IClubRepository extends CrudRepository<Club, Integer> {

    //    @Query("select c from Club c  where c.id in (select max(c.id) from Club c )")
    @Query("select c from Club c  group by  c.students ")
    Iterable<Object[]> studentsPerClub();

    @Query("SELECT COUNT(s) FROM Club c JOIN c.students s ")
    Long nbrStudents();

}
