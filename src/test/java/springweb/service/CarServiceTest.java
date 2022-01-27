package springweb.service;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springweb.domain.Car;
import springweb.exception.CarNotFoundException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;


/**
 * @author Archon  2019/8/28
 * @since 0.1
 */
@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @Test
    void getCarDetails_returnCarInfo() throws CarNotFoundException {
        given(carRepository.findByName("prius")).willReturn(new Car("prius", "hybrid"));

        Car car = carService.getCarDetails("prius");
        assertThat(car.getName()).isEqualTo("prius");
        assertThat(car.getType()).isEqualTo("hybrid");
    }

    @Test
    void getCarDetails_noFound() throws CarNotFoundException {
        Assertions.assertThrows(CarNotFoundException.class, () -> {
            given(carRepository.findByName(anyString())).willReturn(null);
            carService.getCarDetails("prius");
        });
    }

    @Test
    void getAllCars_returnAllCarsList() throws CarNotFoundException {
        given(carRepository.findAll()).willReturn(
            Collections.singletonList(new Car("prius", "hybrid")));

        List<Car> cars = carService.getAllCars();
        assertThat(cars.size()).isEqualTo(1);
        assertThat(cars.get(0)).isEqualTo(new Car("prius", "hybrid"));
    }

    @Test
    void getAllCars_noFound() throws CarNotFoundException {
        Assertions.assertThrows(CarNotFoundException.class, () -> {
            given(carRepository.findAll()).willReturn(null);
            carService.getAllCars();
        });
    }

    @Test
    void getAllCars_noFound2() throws CarNotFoundException {
        Assertions.assertThrows(CarNotFoundException.class, () -> {
            given(carRepository.findAll()).willReturn(Collections.emptyList());
            carService.getAllCars();
        });
    }
}

