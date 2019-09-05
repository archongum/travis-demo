package springweb.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import springweb.domain.Car;
import springweb.exception.CarNotFoundException;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;


/**
 * @author Archon  2019/8/28
 * @since 0.1
 */
@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp() {
        carService = new CarService(carRepository);
    }

    @Test
    public void getCarDetails_returnCarInfo() throws CarNotFoundException {
        given(carRepository.findByName("prius")).willReturn(new Car("prius", "hybrid"));

        Car car = carService.getCarDetails("prius");
        assertThat(car.getName()).isEqualTo("prius");
        assertThat(car.getType()).isEqualTo("hybrid");
    }

    @Test(expected = CarNotFoundException.class)
    public void getCarDetails_noFound() throws CarNotFoundException {
        given(carRepository.findByName(anyString())).willReturn(null);

        carService.getCarDetails("prius");
    }

    @Test
    public void getAllCars_returnAllCarsList() throws CarNotFoundException {
        given(carRepository.findAll()).willReturn(
            Collections.singletonList(new Car("prius", "hybrid")));

        List<Car> cars = carService.getAllCars();
        assertThat(cars.size()).isEqualTo(1);
        assertThat(cars.get(0)).isEqualTo(new Car("prius", "hybrid"));
    }

    @Test(expected = CarNotFoundException.class)
    public void getAllCars_noFound() throws CarNotFoundException {
        given(carRepository.findAll()).willReturn(null);
        carService.getAllCars();
    }

    @Test(expected = CarNotFoundException.class)
    public void getAllCars_noFound2() throws CarNotFoundException {
        given(carRepository.findAll()).willReturn(Collections.emptyList());
        carService.getAllCars();
    }
}

