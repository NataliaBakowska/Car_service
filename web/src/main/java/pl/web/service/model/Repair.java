package pl.web.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * @author Natalia Bąkowska
 * Class representing a single service. Related to one car and one customer, defined by specific time, costs and units.
 */
@Entity(name = "repairs")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @ManyToOne
    @JsonProperty("car")
    private Car car;

    @JsonProperty("startDate")
    private DateTime startDate;

    @JsonProperty("endDate")
    private DateTime endDate;

    //possible change to List<Units>
    @JsonProperty("units")
    private String units;

    @JsonProperty("costs")
    private Double costs;

    @JsonProperty("description")
    private String description;

    public Repair() {
    }

    public Repair(Car car, DateTime startDate, Double costs) {
        this.car = car;
        this.startDate = startDate;
        this.costs = costs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", car=" + car +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", units='" + units + '\'' +
                ", costs=" + costs +
                ", description=" + description +
                '}';
    }
}
