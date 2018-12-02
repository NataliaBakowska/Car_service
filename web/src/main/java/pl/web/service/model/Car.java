package pl.web.service.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Natalia Bąkowska
 * Class representing single vehicle. Every car has a relation to one customer.
 */
@Entity(name = "cars")
@Getter @Setter @NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //possible change to enum
    private String brand;

    private String model;

    private int productionYear;

    private String registrationNumber;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "car")
    private List<Repair> repairs;

    private Long vin;
}
