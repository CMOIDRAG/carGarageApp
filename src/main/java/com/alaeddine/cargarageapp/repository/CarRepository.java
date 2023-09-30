package com.alaeddine.cargarageapp.repository;

import com.alaeddine.cargarageapp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByFuelType(String fuelType);
    List<Car> findByPriceLessThan(Long maxPrice);
    List<Car> findByFuelTypeAndPriceLessThan(String fuelType, Long maxPrice);

    @Query("SELECT DISTINCT c.make FROM Car c")
    List<String> findDistinctMakes();
}

