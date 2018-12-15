package pl.web.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.List;

/**
 * @author Natalia Bąkowska
 * Class representing single vehicle. Every car has a relation to one customer.
 */
@Entity(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    //possible change to enum
    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("productionYear")
    private int productionYear;

    @JsonProperty("registrationNumber")
    private String registrationNumber;

    @ManyToOne
    @JsonProperty("customer")
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "car")
    @JsonProperty("repairs")
    private List<Repair> repairs;

    @JsonProperty("vin")
    private String vin;

    public Car() {
    }

    public Car(String brand, String model, int productionYear, String registrationNumber, Customer customer, String vin) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.registrationNumber = registrationNumber;
        this.customer = customer;
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", customer=" + customer +
//                ", repairs=" + repairs.toString() +
                ", vin=" + vin +
                '}';
    }
}
