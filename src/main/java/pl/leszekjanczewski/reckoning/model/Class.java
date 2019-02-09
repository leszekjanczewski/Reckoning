package pl.leszekjanczewski.reckoning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
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
    private String className;

   @ManyToOne
   @JoinColumn(name = "type_id")
    private TypeOfClass typeOfClass;

    @Column(name = "day_of_week")
    @NotEmpty(message = "Wybierz dzień zajęć")
    private String dayOfWeek;

    @DateTimeFormat(pattern = "hh:mm")
    @Temporal(TemporalType.TIME)
    @Column(name = "start_hour")
    @NotEmpty(message = "Podaj godzinę zajęć")
    private Date startHour;

    @Column(name = "duration")
    @NotEmpty(message = "Podaj czas trwania zajęć")
    private int duration;

    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "classes")
    private Set<Child> children = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "classes_calendars", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "calendar_id"))
    private Set<Calendar> calendars = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "classes_payments", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "payment_id"))
    private Set<Payment> payments = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "classes_installments", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "installment_id"))
    private Set<Installment> installments = new HashSet<>();
}
