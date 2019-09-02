package springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springweb.domain.Car;
import springweb.exception.CarNotFoundException;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Archon  2019/8/28
 * @since
 */
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() throws CarNotFoundException {
        List<Car> rs = new ArrayList<>();
        carRepository.findAll().iterator().forEachRemaining(rs::add);
        if (rs.isEmpty()) {
            throw new CarNotFoundException();
        }
        return rs;
    }

    @Cacheable("cars")
    public Car getCarDetails(String name) throws CarNotFoundException {
        Car car = carRepository.findByName(name);
        if (car == null) {
            throw new CarNotFoundException();
        }
        return car;
    }
}
