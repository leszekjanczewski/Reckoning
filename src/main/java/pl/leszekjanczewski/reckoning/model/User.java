package pl.leszekjanczewski.reckoning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    @NotEmpty(message = "*Proszę wprowadzić imię")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "*Proszę wprowadzić nazwisko")
    private String lastName;

    @Column(name = "enable")
    private boolean enable;

    @Column(name = "email")
    @Email(message = "Proszę wprowadzić prawidłowy adres e-mail")
    @NotEmpty(message = "Proszę wprowadzić adress e-mail")
    private String email;

    @Column(name = "login", unique = true)
    @NotEmpty(message = "*Proszę wprowadzić login")
    private String login;

    @Column(name = "password")
    @Length(min = 5, message = "*Hasło musi mieć co najmniej 5 znaków")
    @NotEmpty(message = "*Hasło nie może być puste")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
