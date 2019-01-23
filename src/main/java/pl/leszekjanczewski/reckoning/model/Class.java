package pl.leszekjanczewski.reckoning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "classes")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long classId;

    @Column(name = "class_name")
    @NotEmpty(message = "Podaj nazwę klasy")
    private String className;

    @Column(name = "day_of_week")
    @NotEmpty(message = "Wybierz dzień zajęć")
    private String dayOfWeek;

    @Column(name = "hour")
    @NotEmpty(message = "Podaj godzinę zajęć")
    private Date hour;

    @Column(name = "duration")
    @NotEmpty(message = "Podaj czas trwania zajęć")
    private int duration;

    @ManyToMany(mappedBy = "classes")
    private Set<Child> children = new HashSet<>();
}
