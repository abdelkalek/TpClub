package com.example.tpclub.Controller;

import com.example.tpclub.Entity.Student;
import com.example.tpclub.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("add")
    @ResponseBody
    public int addStudent(@RequestBody Student u) {
        return  studentService.ajouterStudent(u);
    }

    @DeleteMapping("/remove/{Student-id}")
    @ResponseBody
    public void removeStudent(@PathVariable("Student-id") Integer StudentId) {
        studentService.deleteStudent(StudentId);
    }
    @PutMapping("/modify-Student")
    @ResponseBody
    public Student modifyOrders(@RequestBody Student student) {
        return studentService.updateStudent(student, student.getId());
    }

    @GetMapping("/retrieve-all")
    @ResponseBody
    public List<Student> getStudent() {
        return studentService.retrieveAllStudents();
    }
    @GetMapping("/retrieve/{Student-id}")
    @ResponseBody
    public Student retrieveStudent(@PathVariable("Student-id") Integer id) {
        return studentService.retrieveStudent(id);
    }

    @GetMapping("/count")
    private long countStudent(){
        return studentService.countStudent();
    }

    @GetMapping("/nbrparticipe")
    private long nbrparticipe(){
        return studentService.nbrParticipe();
    }

}

