package pl.leszekjanczewski.reckoning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "types_of_classes")
public class TypeOfClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long typeOfClassId;

    @Column(name = "type_name")
    @NotEmpty(message = "Wprowadź typ klasy")
    private String typeOfClassName;
}
