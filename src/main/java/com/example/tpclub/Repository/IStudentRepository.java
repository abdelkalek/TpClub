package com.example.tpclub.Repository;
import com.example.tpclub.Entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface IStudentRepository extends CrudRepository<Student, Integer> {
  Long countDistinctByClubsNotNull();
}
