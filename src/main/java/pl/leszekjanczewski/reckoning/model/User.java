package pl.leszekjanczewski.reckoning.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column(name = "enable")
    @NotNull
    private boolean enable;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "login", unique = true)
    @NotNull
    private String login;

    @Column(name = "password")
    @NotNull
    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Role> roles = new HashSet<>();
}
