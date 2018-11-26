package pl.web.service.model;

import org.joda.time.DateTime;

/**
 * @author Natalia Bąkowska
 * Class representing a single service. Related to one car and one customer, defined by specific time, costs and units.
 */

public class Repair {

    private Long id;
    private Car car;
    private DateTime startDate;
    private DateTime endDate;
    //possible change to List<Units>
    private String units;
    private Double costs;

}
