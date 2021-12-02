package com.example.tpclub;
import com.example.tpclub.Entity.Classroom;
import com.example.tpclub.Entity.Club;
import com.example.tpclub.Repository.IClassroomRepository;
import com.example.tpclub.Repository.IClubRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.tpclub.Entity.Student;
import com.example.tpclub.Repository.IStudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
//http://localhost:8080/swagger-ui/
public class TpClubApplication {
    private static final Logger LOGGER = LogManager.getLogger(TpClubApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(TpClubApplication.class, args);
        LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");
    }
    @Bean
    public CommandLineRunner demo(IStudentRepository sturepo, IClubRepository clubrep, IClassroomRepository clarep) {
        return (args) -> {
            Club c = new Club("A201", "2019");
            Club c1 = new Club("A202", "2011");
            Club c2 = new Club("A301", "2001");
            List<Club> clubs = new ArrayList<>();
            clubs.add(c);
            clubs.add(c1);
            List<Club> clubs2 = new ArrayList<>();
            clubs2.add(c1);
            clubs2.add(c2);
            clubrep.save(c);
            clubrep.save(c1);
            clubrep.save(c2);
            Classroom cl = new Classroom("GL");
            Classroom cl1 = new Classroom("Reseaux");
            Classroom cl2 = new Classroom("BIG Data");
            List<Classroom> classrooms = new ArrayList<>();
            classrooms.add(cl);
            classrooms.add(cl1);
            classrooms.add(cl2);
            clarep.saveAll(classrooms);

            Student u = new Student("Abdelkhalek", "Abdelkhalek@gmail.com");
            Student u1 = new Student("joneDee", "saleh@gmail.com");
            Student u2 = new Student("Alex", "alexa@gmail.com");
            Student u3 = new Student("Jack", "jacksparo@gmail.com");
            Student u4 = new Student("yani", "yani@gmail.com");
            List<Student> students = new ArrayList<>();
            List<Student> studentb = new ArrayList<>();
            students.add(u);
            students.add(u1);
            studentb.add(u2);
            studentb.add(u3);
            studentb.add(u4);
            sturepo.saveAll(students);
            sturepo.saveAll(studentb);
            u.setClassroom(cl);
            u.setClubs(clubs2);
            sturepo.save(u);
            u1.setClassroom(cl1);
            u1.setClubs(clubs);
            sturepo.save(u1);
            u2.setClassroom(cl1);
            u2.setClubs(clubs);
            sturepo.save(u2);
            u3.setClassroom(cl2);
            u3.setClubs(clubs);
            sturepo.save(u3);
            u4.setClassroom(cl2);
            u4.setClubs(clubs2);
            sturepo.save(u4);
            c.setStudents(studentb);
            c1.setStudents(students);
            c2.setStudents(students);

            clubrep.save(c);
            clubrep.save(c1);
            clubrep.save(c2);


        };
    }

}
