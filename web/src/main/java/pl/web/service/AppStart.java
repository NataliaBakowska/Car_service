package pl.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.web.service.model.Car;
import pl.web.service.model.Customer;
import pl.web.service.service.CarService;
import pl.web.service.service.CustomerService;

@Component
public class AppStart implements ApplicationRunner {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CarService carService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer customer1 = new Customer(123456789L, "test", "test");
        Customer customer2 = new Customer(111111111L, "test2", "test2");
        customerService.saveCustomer(customer1);
        customerService.saveCustomer(customer2);

        Car car1 = new Car("Fiat", "Freemont", 2018, "KS882901", customer1,
                "1HGCM82633A004352");
        Car car2 = new Car("Ford", "Fiesta", 2010, "KF232009", customer2,
                "1HGCM82633A0043230");
        carService.saveCar(car1);
        carService.saveCar(car2);
    }
}
