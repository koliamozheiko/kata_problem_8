package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;
@Service
public class CarServiceImp  implements CarService {

    private CarDao car_dao;
    @Autowired
    public CarServiceImp(CarDao carDao) {
        this.car_dao = carDao;
    }
    @Override
    public List<Car> showAllCars() {
        return car_dao.showAllCars();
    }

    @Override
    public List<Car> showSomeCars(int count) {
        return car_dao.showSomeCars(count);
    }
}
