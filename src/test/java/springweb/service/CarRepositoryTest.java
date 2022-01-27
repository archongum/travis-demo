package springweb.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import springweb.domain.Car;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Archon  2019/8/28
 * @since 0.1
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findByName() {
        Car savedCar = testEntityManager.persistAndFlush(new Car("prius", "hybrid"));

        Car car = carRepository.findByName("prius");

        System.out.println("---------- savedCar --------");
        System.out.println(savedCar);
        System.out.println("---------- car --------");
        System.out.println(car);

        assertThat(car).isEqualTo(savedCar);
    }
}
