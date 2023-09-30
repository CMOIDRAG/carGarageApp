package com.alaeddine.cargarageapp.service;

import com.alaeddine.cargarageapp.model.Car;
import com.alaeddine.cargarageapp.repository.CarRepository;
import com.alaeddine.cargarageapp.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @MockBean
    private CarRepository carRepository;

    @Test
    public void testAddCar() {
        Car car = new Car("Make", "Model", LocalDate.of(2020, Month.JANUARY, 8), 20000L, "DIESEL", 100, "MANUAL", "picture.jpg");
        when(carRepository.save(any(Car.class))).thenReturn(car);

        Car created = carService.addCar(car);
        assertThat(created.getMake()).isEqualTo("Make");
        // Add more assertions based on your business logic
    }
}
