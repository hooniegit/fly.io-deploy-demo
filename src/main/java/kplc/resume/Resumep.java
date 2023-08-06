package kplc.resume;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Resumep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=10)
    private String name;

    @Column(length=10)
    private String birthday;

    @Column(columnDefinition = "TEXT")
    private String resume_inside;
}
