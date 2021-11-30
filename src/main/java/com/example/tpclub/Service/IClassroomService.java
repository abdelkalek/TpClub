package com.example.tpclub.Service;
import com.example.tpclub.Entity.Classroom;
import java.util.List;
public interface IClassroomService {
     List<Classroom> retrieveAllClassrooms();
     int ajouterClassroom(Classroom cl);
     void deleteClassroom(Integer id);
     Classroom updateClassroom(Classroom cl, int classroomId);
     Classroom retrieveClassroom(Integer id);

}
