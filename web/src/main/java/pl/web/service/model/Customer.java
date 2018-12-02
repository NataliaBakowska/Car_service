package pl.web.service.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Natalia Bąkowska
 * Class representiong a customer. One customer can be assigned to many vehicles.
 */
@Entity(name = "customers")
@Getter @Setter @NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "customer")
    private List<Car> cars;

    private Long telephoneNumber;

    private String firstName;

    private String lastName;
}
