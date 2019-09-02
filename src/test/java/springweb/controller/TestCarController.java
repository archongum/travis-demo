package springweb.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import springweb.domain.Car;
import springweb.exception.CarNotFoundException;
import springweb.service.CarService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Archon  2019/8/28
 * @since
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class TestCarController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void testGetCar_shouldReturnCar() throws Exception {
        given(carService.getCarDetails(anyString())).willReturn(new Car("prius", "hybrid"));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("code").value(200))
               .andExpect(jsonPath("data.name").value("prius"))
               .andExpect(jsonPath("data.type").value("hybrid"));
    }

    @Test
    public void testGetCar_noFound() throws Exception {
        given(carService.getCarDetails(anyString())).willThrow(new CarNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("code").value(404))
               .andExpect(jsonPath("data").value("Car not found"));
    }

    @Test
    public void testGetCar_unknownException() throws Exception {
        given(carService.getCarDetails(anyString())).willThrow(new RuntimeException("unknown exception"));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("code").value(500))
            .andExpect(jsonPath("data").value("unknown exception"));
    }
}
