package com.example.tpclub.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nsc")
    private String nsc ;
    @Column(name = "emil")
    private String email ;
    public Student(String nsc, String email) {
        this.nsc = nsc;
        this.email = email;
    }
    @ManyToOne
    @JsonIgnoreProperties("classuser")
    private Classroom classroom;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Club> clubs;
    public Student(String nsc, String email, Classroom classroom, List<Club> clubs) {
        this.nsc = nsc;
        this.email = email;
        this.classroom = classroom;
        this.clubs = clubs;
    }

    public Student(String nsc, String email, List<Club> clubs) {
        this.nsc = nsc;
        this.email = email;
        this.clubs = clubs;
    }
}
