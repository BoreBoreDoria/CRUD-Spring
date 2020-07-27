package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Car;
import web.repository.CarRepository;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService{
    @Autowired
    CarRepository repo;

    public void save(Car customer) {
        repo.save(customer);
    }

    public List<Car> listAll() {
        return (List<Car>) repo.findAll();
    }

    public Car get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
