package pl.leszekjanczewski.reckoning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long divisionId;

    @Column(name = "division_name")
    private String divisionName;

   @ManyToOne
   @JoinColumn(name = "type_id")
    private TypeOfDivision typeOfDivision;

    @Column(name = "day_of_week")
    @NotEmpty(message = "Wybierz dzień zajęć")
    private String dayOfWeek;

//    @DateTimeFormat(pattern = "hh:mm")
//    @Temporal(TemporalType.TIME)
    @Column(name = "start_hour")
//    @NotEmpty(message = "Podaj godzinę zajęć")
    private LocalTime startHour;

    @Column(name = "duration")
//    @NotEmpty(message = "Podaj czas trwania zajęć")
    private int duration;

    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "divisions")
    private Set<Child> children = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(name = "divisions_calendars", joinColumns = @JoinColumn(name = "division_id"), inverseJoinColumns = @JoinColumn(name = "calendar_id"))
    private Set<Calendar> calendars = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(name = "divisions_payments", joinColumns = @JoinColumn(name = "division_id"), inverseJoinColumns = @JoinColumn(name = "payment_id"))
    private Set<Payment> payments = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(name = "divisions_installments", joinColumns = @JoinColumn(name = "division_id"), inverseJoinColumns = @JoinColumn(name = "installment_id"))
    private Set<Installment> installments = new HashSet<>();
}
