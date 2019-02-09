package pl.leszekjanczewski.reckoning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private long clientId;

    @Column(name = "first_name")
    @NotEmpty(message = "*Proszę wprowadzić imię")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "*Proszę wprowadzić nazwisko")
    private String lastName;

    @Column(name = "gender")
    private char gender;

    @Column(name = "active")
    private boolean active;

    @Column(name = "email")
    @Email(message = "Proszę wprowadzić prawidłowy adres e-mail")
    @NotEmpty(message = "Proszę wprowadzić adress e-mail")
    private String email;

    @Column(name = "phone")
    @NotEmpty(message = "Proszę wprowadzić numer telefonu")
    private String phone;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "post_code")
    private String postCode;

    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "clients_payments", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "paymant_id"))
    private Set<Payment> payments = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "clients_installments", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "installment_id"))
    private Set<Installment> installments = new HashSet<>();
}
