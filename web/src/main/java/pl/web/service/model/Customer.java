package pl.web.service.model;

/**
 * @author Natalia Bąkowska
 * Class representiong a customer. One customer can be assigned to many vehicles.
 */

public class Customer {

    private Long id;
    private Car car;
    private Long telephoneNumber;
    private String firstName;
    private String lastName;
}
