package com.alaeddine.cargarageapp.controller;

import com.alaeddine.cargarageapp.model.Car;
import com.alaeddine.cargarageapp.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;


import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {


    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void testGetCars() throws Exception {
        Car car = new Car("Make", "Model", LocalDate.of(2020, Month.JANUARY, 8), 20000L, "DIESEL", 100, "MANUAL", "picture.jpg");
        List<Car> cars = Arrays.asList(car);

//        when(carService.getAllCars()).thenReturn(cars);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/cars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].make", is("Make")));
    }
}

