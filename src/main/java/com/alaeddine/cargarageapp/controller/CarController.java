package com.alaeddine.cargarageapp.controller;

import com.alaeddine.cargarageapp.model.Car;
import com.alaeddine.cargarageapp.service.CarService;
import io.swagger.annotations.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiParam;


import java.util.List;


@Api(value = "Car Management System", description = "Operations pertaining to car in Car Management System")
@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @ApiOperation(value = "Add a new car to the catalog", response = Car.class)
    @PostMapping("/add")
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @ApiOperation(value = "Get a list of all cars by Fuel Type and Max Price", response = List.class)
    @GetMapping("/search")
    public List<Car> getCarsByFuelTypeAndMaxPrice(@RequestParam String fuelType, @RequestParam Long maxPrice) {
        return carService.getCarsByFuelTypeAndMaxPrice(fuelType, maxPrice);
    }

    @ApiOperation(value = "Get a list of all distinct car makes", response = List.class)
    @GetMapping("/makes")
    public List<String> getDistinctMakes() {
        return carService.getDistinctMakes();
    }

    @ApiOperation(value = "Update the picture of a car by its ID", response = Car.class)
    @PutMapping("/update/picture/{id}")
    public Car updateCarPicture(@PathVariable Long id, @RequestParam String newPicture) {
        return carService.updateCarPicture(id, newPicture);
    }
}
