package pl.leszekjanczewski.reckoning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "amount")
    private Double amount;

    @Temporal(TemporalType.DATE)
    @Column(name = "paymant_day")
    private Date paymantDay;

    @ManyToMany(mappedBy = "payments")
    private Set<Client> clients = new HashSet<>();

    @ManyToMany(mappedBy = "payments")
    private Set<Child> children = new HashSet<>();

    @ManyToMany(mappedBy = "payments")
    private Set<Class> classes = new HashSet<>();

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Installment installment;
}
