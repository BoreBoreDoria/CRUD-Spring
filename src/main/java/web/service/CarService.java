package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> listAll();
    void save(Car car);
    Car get(int id);
    void delete(int id);
}
