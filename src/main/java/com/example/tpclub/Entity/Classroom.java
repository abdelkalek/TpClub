package com.example.tpclub.Entity;

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
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name ;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> classuser;

    public Classroom(String name) {
        this.name = name;
    }
    public Classroom(String name, List<Student> classuser) {
        this.name = name;
        this.classuser = classuser;
    }
}
