package springweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springweb.domain.Car;
import springweb.service.CarRepository;

import javax.transaction.Transactional;


/**
 * MyRunner.
 *
 * @author Archon  2019/8/28
 * @since 0.1
 */
@Component
public class MyRunner implements CommandLineRunner {

    private final CarRepository carRepository;

    @Autowired
    public MyRunner(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Car c1 = new Car("prius", "hybrid");
        Car c2 = new Car("prius2", "hybrid");
        carRepository.save(c1);
        carRepository.save(c2);
    }
}
