package web.repository;

import org.springframework.data.repository.CrudRepository;
import web.model.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
