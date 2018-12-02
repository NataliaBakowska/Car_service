package pl.web.service.service;

import pl.web.service.model.Car;
import pl.web.service.repository.CarRepository;

import java.util.Optional;

public class CarService {

    CarRepository carRepository;

    public void saveAction(Car car) {
        carRepository.save(car);
    }

    public Optional<Car> getById(Long id) {
        return carRepository.findById(id);
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }

    public void updateCar(Long id, Car newCar) {
        Car carToEdit = carRepository.findById(id).get();
        carToEdit = newCar;
    }
}
