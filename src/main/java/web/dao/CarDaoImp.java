package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class CarDaoImp implements CarDao {
    private List<Car> cars;

    {
        cars = new ArrayList<>(List.of(
                new Car("mazda", 3, "red"),
                new Car("mercedes", 5, "blue"),
                new Car("bmw", 8, "white"),
                new Car("bmw", 6, "green"),
                new Car("honda", 2, "white")));
    }

    @Override
    public List<Car> showAllCars() {
        return cars;
    }

    @Override
    public List<Car> showSomeCars(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }


}
