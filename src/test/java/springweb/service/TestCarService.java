package springweb.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import springweb.domain.Car;
import springweb.exception.CarNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
public class TestCarService {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp() {
        carService = new CarService(carRepository);
    }

    @Test
    public void testGetCarDetails_returnCarInfo() throws CarNotFoundException {
        given(carRepository.findByName("prius")).willReturn(new Car("prius", "hybrid"));

        Car car = carService.getCarDetails("prius");
        assertThat(car.getName()).isEqualTo("prius");
        assertThat(car.getType()).isEqualTo("hybrid");
    }

    @Test(expected = CarNotFoundException.class)
    public void testGetCarDetails_noFound() throws CarNotFoundException {
        given(carRepository.findByName(anyString())).willReturn(null);

        carService.getCarDetails("prius");
    }
}

