package com.example.db_project.resource;

import com.example.db_project.model.Car;
import com.example.db_project.model.Owner;
import com.example.db_project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarResource {

    private final CarService carService;

    @Autowired
    public CarResource(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Car> getAllCars() {
        return carService.selectAllCars();
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{carId}"
    )
    public Car getCarById(@PathVariable("carId") Long carId) {
        return carService.selectCarById(carId);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewCar(@RequestBody Car car) {
        carService.insertNewCar(car);
    }

    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{carId}"
    )
    public void updateCar(@PathVariable("carId") Long carId,
                          @RequestBody Car update) {
        carService.updateCar(carId, update);
    }

    @DeleteMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{carId}"
    )
    public void removeCar(@PathVariable("carId") Long carId) {
        carService.deleteCar(carId);
    }

    ////////////
    @GetMapping(
            path = "test"
    )
    public void addTestCar() {
        Owner owner = new Owner("Joe", "Jones");
        Car car = new Car("BMW", "6", "White", 2005, owner);
        carService.insertNewCar(car);
    }

}
