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
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ref;
    private String creation_date;
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("clubs")
    private List<Student> Students;
}
