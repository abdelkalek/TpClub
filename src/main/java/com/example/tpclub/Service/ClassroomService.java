package com.example.tpclub.Service;
import com.example.tpclub.Entity.Classroom;
import com.example.tpclub.Entity.Student;
import com.example.tpclub.Repository.IClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService implements IClassroomService {
 @Autowired
    IClassroomRepository classRep;
    @Override
    public List<Classroom> retrieveAllClassrooms() {
        List<Classroom> classromms = new ArrayList<>();
        classRep.findAll().forEach(classromms::add);
        return classromms;
    }

    @Override
    public int ajouterClassroom(Classroom cl) {
        classRep.save(cl);
        return cl.getId();
    }

    @Override
    public void deleteClassroom(Integer id) {
         Classroom classroom = classRep.findById(id).orElse(null);
        classRep.delete(classroom);
    }

    @Override
    public Classroom updateClassroom(Classroom cl, int classroomId) {
         Classroom classroom = classRep.findById(classroomId).orElse(null);
        classRep.save(cl);
        return classroom;
    }

    @Override
    public Classroom retrieveClassroom(Integer id) {
         Classroom classroom = classRep.findById(id).orElse(null);
        return classroom;
    }
}
