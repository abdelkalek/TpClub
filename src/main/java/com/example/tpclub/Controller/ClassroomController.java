package com.example.tpclub.Controller;
import com.example.tpclub.Entity.Classroom;
import com.example.tpclub.Service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomservice;

    @PostMapping("add")
    @ResponseBody
    public int addClassroom(@RequestBody Classroom u) {
        return  classroomservice.ajouterClassroom(u);
    }
    @DeleteMapping("/remove/{Classroom-id}")
    @ResponseBody
    public void removeClassroom(@PathVariable("Classroom-id") Integer ClassroomId) {
        classroomservice.deleteClassroom(ClassroomId);
    }
    @PutMapping("/modify-Classroom")
    @ResponseBody
    public Classroom modifyOrders(@RequestBody Classroom classroom) {
        return classroomservice.updateClassroom(classroom, classroom.getId());
    }
    @GetMapping("/retrieve-all")
    @ResponseBody
    public List<Classroom> getClassroom() {
        return classroomservice.retrieveAllClassrooms();
    }
    @GetMapping("/retrieve/{Classroom-id}")
    @ResponseBody
    public Classroom retrieveClassroom(@PathVariable("Classroom-id") Integer id) {
        return classroomservice.retrieveClassroom(id);
    }

}
