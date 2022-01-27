package springweb.controller;

import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import springweb.domain.BaseResponse.BaseStatus;
import springweb.domain.Car;
import springweb.exception.CarNotFoundException;
import springweb.service.CarService;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Archon  2019/8/28
 * @since 0.1
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    void getCar_shouldReturnCar() throws Exception {
        given(carService.getCarDetails(anyString())).willReturn(new Car("prius", "hybrid"));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.status").value(BaseStatus.OK.name()))
               .andExpect(jsonPath("$.data.name").value("prius"))
               .andExpect(jsonPath("$.data.type").value("hybrid"));
    }

    @Test
    void getCar_noFound() throws Exception {
        given(carService.getCarDetails(anyString())).willThrow(new CarNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
               .andExpect(status().isNotFound())
               .andExpect(jsonPath("$.status").value(BaseStatus.NOT_FOUND.name()))
               .andExpect(jsonPath("$.data").value("Car Not Found"));
    }

    @Test
    void getCar_unknownException() throws Exception {
        given(carService.getCarDetails(anyString())).willThrow(new RuntimeException("Unknown Exception"));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
            .andExpect(status().isInternalServerError())
            .andExpect(jsonPath("$.status").value(BaseStatus.INTERNAL_SERVER_ERROR.name()))
            .andExpect(jsonPath("$.data").value("Unknown Exception"));
    }

    @Test
    void getAllCars_shouldReturnCarList() throws Exception {
        given(carService.getAllCars()).willReturn(
            Collections.singletonList(new Car("prius", "hybrid")));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value(BaseStatus.OK.name()))
            .andExpect(jsonPath("$.data[0].name").value("prius"))
            .andExpect(jsonPath("$.data[0].type").value("hybrid"));
    }

    @Test
    void getAllCars_noFound() throws Exception {
        given(carService.getAllCars()).willThrow(new CarNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/cars"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.status").value(BaseStatus.NOT_FOUND.name()))
            .andExpect(jsonPath("$.data").value("Car Not Found"));
    }

    @Test
    void getAllCars_unknownException() throws Exception {
        given(carService.getAllCars()).willThrow(new RuntimeException("Unknown Exception"));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars"))
            .andExpect(status().isInternalServerError())
            .andExpect(jsonPath("status").value(BaseStatus.INTERNAL_SERVER_ERROR.name()))
            .andExpect(jsonPath("data").value("Unknown Exception"));
    }
}
