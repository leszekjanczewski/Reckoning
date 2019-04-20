package pl.leszekjanczewski.reckoning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private Long childId;

    @Column(name = "first_name")
    @NotEmpty(message = "*Proszę wprowadzić imię")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "*Proszę wprowadzić nazwisko")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private char gender;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "child_division", joinColumns = {@JoinColumn(name = "child_id")}, inverseJoinColumns = {@JoinColumn(name = "division_id")})
    private Set<Division> divisions = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(name = "child_payment", joinColumns = {@JoinColumn(name = "child_id")}, inverseJoinColumns = {@JoinColumn(name = "paymant_id")})
    private Set<Payment> payments = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(name = "child_installment", joinColumns = {@JoinColumn(name = "child_id")}, inverseJoinColumns = {@JoinColumn(name = "installment_id")})
    private Set<Installment> installments = new HashSet<>();
}
