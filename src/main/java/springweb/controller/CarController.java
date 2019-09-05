package springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import springweb.domain.BaseResponse;
import springweb.domain.Car;
import springweb.exception.CarNotFoundException;
import springweb.service.CarService;

import java.util.List;


/**
 * @author Archon  2019/8/28
 * @since 0.1
 */
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name) throws CarNotFoundException {
        return carService.getCarDetails(name);
    }

    @GetMapping("/cars")
    private List<Car> getAllCars() throws CarNotFoundException {
        return carService.getAllCars();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private BaseResponse carNotFoundHandler(CarNotFoundException e) {
        return new BaseResponse<>(404, e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private BaseResponse unknownException(Exception e) {
        return new BaseResponse<>(500, e.getMessage());
    }
}
