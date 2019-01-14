package pl.leszekjanczewski.reckoning.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "groups")
@Data
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_name")
    private String groupName;
}