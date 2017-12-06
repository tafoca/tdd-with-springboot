package com.demo.tdd.web;

import com.demo.tdd.domain.Car;
import com.demo.tdd.service.CarNotFoundException;
import com.demo.tdd.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    private CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("/cars/{name}")
    public Car getCar(@PathVariable String name) {
        return service.getCarDetails(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException ex) {}

}
