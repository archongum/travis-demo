package springweb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import springweb.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Archon  2019/8/28
 * @since 0.1
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByName() {
        Car savedCar = testEntityManager.persistAndFlush(new Car("prius", "hybrid"));

        Car car = carRepository.findByName("prius");

        System.out.println("---------- savedCar --------");
        System.out.println(savedCar);
        System.out.println("---------- car --------");
        System.out.println(car);

        assertThat(car).isEqualTo(savedCar);
    }
}
