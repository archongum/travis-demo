package springweb.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springweb.domain.Car;
import springweb.exception.CarNotFoundException;


/**
 * CarService.
 *
 * @author Archon  2019/8/28
 * @since 0.1
 */
@Service
@AllArgsConstructor
@Slf4j
public class CarService {

    private final CarRepository carRepository;

    /**
     * Get all cars.
     *
     * @return all cars
     * @throws CarNotFoundException car not found
     */
    public List<Car> getAllCars() throws CarNotFoundException {
        log.warn("getAllCars");
        List<Car> rs = new ArrayList<>();
        Optional.ofNullable(carRepository.findAll()).orElse(Collections.emptyList()).iterator().forEachRemaining(rs::add);
        if (rs.isEmpty()) {
            throw new CarNotFoundException();
        }
        return rs;
    }

    /**
     * get car details
     *
     * @param name car name
     * @return Car
     * @throws CarNotFoundException car not found
     */
    @Cacheable("cars")
    public Car getCarDetails(String name) throws CarNotFoundException {
        log.warn("getCarDetails, name: {}", name);
        Car car = carRepository.findByName(name);
        if (car == null) {
            throw new CarNotFoundException();
        }
        // Return trace id in response.
        car.setRemark(String.format("span id: %s, segment id: %s, trace id: %s", TraceContext.spanId(), TraceContext.segmentId(), TraceContext.traceId()));
        return car;
    }
}
