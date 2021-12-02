package com.example.tpclub.Service;

import com.example.tpclub.Entity.Student;
import com.example.tpclub.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepository sturep;
    @Override
    public List<Student> retrieveAllStudents() {
        List<Student> students = new ArrayList<>();
        sturep.findAll().forEach(students::add);
        return students;
    }
    @Override
    public int ajouterStudent(Student s) {
        sturep.save(s);
        return s.getId();
    }

    @Override
    public void deleteStudent(Integer id) {
        Student student = sturep.findById(id).orElse(null);
        sturep.delete(student);

    }
    @Override
    public Student updateStudent(Student s, int studentId) {
        Student student = sturep.findById(studentId).orElse(null);
        sturep.save(s);
        return student;
    }

    @Override
    public Student retrieveStudent(Integer id) {
        Student student = sturep.findById(id).orElse(null);
        return student;
    }

    @Override
    public long countStudent() {
        return sturep.count();
    }

    @Override
    public long nbrParticipe() {
        return  sturep.countDistinctByClubsNotNull();
    }
}
