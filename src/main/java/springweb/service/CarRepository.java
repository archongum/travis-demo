package springweb.service;

import org.springframework.data.repository.CrudRepository;
import springweb.domain.Car;


/**
 * CarRepository.
 *
 * @author Archon  2019/8/28
 * @since 0.1
 */
public interface CarRepository extends CrudRepository<Car, Long> {

    Car findByName(String name);
}
