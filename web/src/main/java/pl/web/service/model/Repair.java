package pl.web.service.model;

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
@Getter @Setter @NoArgsConstructor
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Car car;

    private DateTime startDate;

    private DateTime endDate;

    //possible change to List<Units>
    private String units;

    private Double costs;

}
