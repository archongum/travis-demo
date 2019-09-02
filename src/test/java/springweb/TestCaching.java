package springweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;
import springweb.domain.Car;
import springweb.exception.CarNotFoundException;
import springweb.service.CarRepository;
import springweb.service.CarService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * @author Archon  2019/8/28
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@EnableCaching
public class TestCaching {

    @Autowired
    private CarService carService;

    @MockBean
    private CarRepository carRepository;

    @Test
    public void testCaching() throws CarNotFoundException {
        given(carRepository.findByName(anyString())).willReturn(new Car("prius", "hybrid"));

        carService.getCarDetails("prius");
        carService.getCarDetails("prius");

        verify(carRepository, times(1)).findByName("prius");
    }
}
