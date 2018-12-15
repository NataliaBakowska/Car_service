package pl.web.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import java.util.List;

/**
 * @author Natalia Bąkowska
 * Class representiong a customer. One customer can be assigned to many vehicles.
 */
@Entity(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @OneToMany(mappedBy = "customer")
    @JsonProperty("cars")
    private List<Car> cars;

    @JsonProperty("telephoneNumber")
    private Long telephoneNumber;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    private String password;

    public Customer() {
    }

    public Customer(Long telephoneNumber, String firstName, String lastName) {
        this.telephoneNumber = telephoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", cars=" + cars +
                ", telephoneNumber=" + telephoneNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
