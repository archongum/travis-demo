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

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Archon  2019/8/28
 * @since 0.1
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void getCar_shouldReturnCar() throws Exception {
        given(carService.getCarDetails(anyString())).willReturn(new Car("prius", "hybrid"));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.status").value(200))
               .andExpect(jsonPath("$.data.name").value("prius"))
               .andExpect(jsonPath("$.data.type").value("hybrid"));
    }

    @Test
    public void getCar_noFound() throws Exception {
        given(carService.getCarDetails(anyString())).willThrow(new CarNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
               .andExpect(status().isNotFound())
               .andExpect(jsonPath("$.status").value(404))
               .andExpect(jsonPath("$.data").value("Car Not Found"));
    }

    @Test
    public void getCar_unknownException() throws Exception {
        given(carService.getCarDetails(anyString())).willThrow(new RuntimeException("Unknown Exception"));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
            .andExpect(status().isInternalServerError())
            .andExpect(jsonPath("$.status").value(500))
            .andExpect(jsonPath("$.data").value("Unknown Exception"));
    }

    @Test
    public void getAllCars_shouldReturnCarList() throws Exception {
        given(carService.getAllCars()).willReturn(
            Collections.singletonList(new Car("prius", "hybrid")));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(200))
            .andExpect(jsonPath("$.data[0].name").value("prius"))
            .andExpect(jsonPath("$.data[0].type").value("hybrid"));
    }

    @Test
    public void getAllCars_noFound() throws Exception {
        given(carService.getAllCars()).willThrow(new CarNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/cars"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.status").value(404))
            .andExpect(jsonPath("$.data").value("Car Not Found"));
    }

    @Test
    public void getAllCars_unknownException() throws Exception {
        given(carService.getAllCars()).willThrow(new RuntimeException("Unknown Exception"));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars"))
            .andExpect(status().isInternalServerError())
            .andExpect(jsonPath("status").value(500))
            .andExpect(jsonPath("data").value("Unknown Exception"));
    }
}
