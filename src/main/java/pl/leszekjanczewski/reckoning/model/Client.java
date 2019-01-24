package pl.leszekjanczewski.reckoning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

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
}
