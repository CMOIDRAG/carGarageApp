package com.alaeddine.cargarageapp.service;

import com.alaeddine.cargarageapp.model.Car;
import com.alaeddine.cargarageapp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car addCar(Car car) {
        if (car.getRegistrationDate().getYear() > 2015) {
            return carRepository.save(car);
        }
        // Handle error for cars older than 2015
        return null;
    }

    public List<Car> getCarsByFuelTypeAndMaxPrice(String fuelType, Long maxPrice) {
        return carRepository.findByFuelTypeAndPriceLessThan(fuelType, maxPrice);
    }

    public List<String> getDistinctMakes() {
        return carRepository.findDistinctMakes();
    }

    public Car updateCarPicture(Long id, String newPicture) {
        Car existingCar = carRepository.findById(id).orElse(null);
        if (existingCar != null) {
            existingCar.setPicture(newPicture);
            return carRepository.save(existingCar);
        }
        // Handle error for non-existing car
        return null;
    }
}
