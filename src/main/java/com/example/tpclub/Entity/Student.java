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


}
