package springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springweb.domain.Car;
import springweb.exception.CarNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


/**
 * CarService.
 *
 * @author Archon  2019/8/28
 * @since 0.1
 */
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Get all cars.
     *
     * @return all cars
     * @throws CarNotFoundException
     */
    public List<Car> getAllCars() throws CarNotFoundException {
        List<Car> rs = new ArrayList<>();
        Optional.ofNullable(carRepository.findAll()).orElse(Collections.emptyList())
            .iterator().forEachRemaining(rs::add);
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
