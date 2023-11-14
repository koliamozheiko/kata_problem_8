package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;


@Controller
public class CarController {
    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String show(@RequestParam(value = "count", defaultValue = "0") int count, Model model) {
        List<Car> carsToShow;
        if (count > 0 && count <=5) {
            carsToShow = carService.showSomeCars(count);
        } else {
            carsToShow = carService.showAllCars();
        }
        model.addAttribute("cars", carsToShow);
        return "cars";
    }
}
