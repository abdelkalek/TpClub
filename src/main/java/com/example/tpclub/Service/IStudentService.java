package com.example.tpclub.Service;
import com.example.tpclub.Entity.Student;
import java.util.List;
public interface IStudentService {
     List<Student> retrieveAllStudents();
     int ajouterStudent(Student s);
     void deleteStudent(Integer id);
     Student updateStudent(Student s, int studentId);
     Student retrieveStudent(Integer id);
     long countStudent();
     long nbrParticipe();
}
