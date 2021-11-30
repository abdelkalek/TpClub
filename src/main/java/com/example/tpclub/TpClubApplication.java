package com.example.tpclub;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.tpclub.Entity.Student;
import com.example.tpclub.Repository.IStudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
//http://localhost:8080/swagger-ui.html
public class TpClubApplication {
    private static final Logger LOGGER = LogManager.getLogger(TpClubApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(TpClubApplication.class, args);
        LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");
    }
@Bean
    public CommandLineRunner demo(IStudentRepository studentRepository){
        return  (args) -> {
        Student u = new Student("jack", "jack@gmail.com");
        Student ue = new Student("Abdelkhalek", "fafaz@gmail.com");
        studentRepository.save(ue);
        studentRepository.save(u);
    };
}

}
