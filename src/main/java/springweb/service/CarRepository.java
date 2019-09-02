package springweb.service;

import org.springframework.data.repository.CrudRepository;
import springweb.domain.Car;


/**
 * @author Archon  2019/8/28
 * @since
 */
public interface CarRepository extends CrudRepository<Car, Long> {
    Car findByName(String name);
}
