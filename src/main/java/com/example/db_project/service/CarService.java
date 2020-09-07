package com.example.db_project.service;

import com.example.db_project.dao.CarDao;
import com.example.db_project.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarDao carDao;

    @Autowired
    public CarService(@Qualifier("mysql") CarDao carDao) {
        this.carDao = carDao;
    }

    public List<Car> selectAllCars() {
        return carDao.findAll();
    }

    public Car selectCarById(Long carId) {
        return carDao.findById(carId)
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format("Car %d does not exists", carId)));
    }

    public int updateCar(Long carId, Car update) {
        carDao.findById(carId).map(car -> {
            car.setMake(update.getMake());
            car.setModel(update.getModel());
            car.setColor(update.getColor());
            car.setYear(update.getYear());
            car.setOwner(update.getOwner());
            return carDao.save(car);
        }).orElseGet(() -> {
            update.setId(carId);
            return carDao.save(update);
        });
        return 1;
    }


    public int deleteCar(Long carId) {
        carDao.deleteById(carId);
        return 1;
    }

    public int insertNewCar(Car car) {
        if (car != null) {
            carDao.save(car);
            return 1;
        }
        return -1;
    }


}
