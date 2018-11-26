package pl.web.service.model;

/**
 * @author Natalia Bąkowska
 * Class representing single vehicle. Every car has a relation to one customer.
 */

public class Car {

    private Long id;
    //possible change to enum
    private String brand;
    private String model;
    private int productionYear;
    private String registrationNumber;
    private Customer customer;
    private Repair repair;
    private Long vin;
}
