package pl.leszekjanczewski.reckoning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "child_class", joinColumns = {@JoinColumn(name = "child_id")}, inverseJoinColumns = {@JoinColumn(name = "class_id")})
    private Set<Class> classes = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "child_payment", joinColumns = {@JoinColumn(name = "child_id")}, inverseJoinColumns = {@JoinColumn(name = "paymant_id")})
    private Set<Payment> payments = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "child_installment", joinColumns = {@JoinColumn(name = "child_id")}, inverseJoinColumns = {@JoinColumn(name = "installment_id")})
    private Set<Installment> installments = new HashSet<>();
}
