package web.dao;

import web.model.Car;

import java.util.List;

public interface CarDao {
    List<Car> showAllCars();
    List<Car> showSomeCars(int count);
}
