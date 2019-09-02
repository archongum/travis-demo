package springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springweb.domain.BaseResponse;
import springweb.domain.BaseResponse.Code;
import springweb.exception.CarNotFoundException;
import springweb.service.CarService;


/**
 * @author Archon  2019/8/28
 * @since
 */
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars/{name}")
    private BaseResponse getCar(@PathVariable String name) throws CarNotFoundException {
        return BaseResponse.newInstance(Code.OK, carService.getCarDetails(name));
    }

    @GetMapping("/cars")
    private BaseResponse getAllCar() throws CarNotFoundException {
        return BaseResponse.newInstance(Code.OK, carService.getAllCars());
    }

    @ExceptionHandler
    private BaseResponse carNotFoundHandler(CarNotFoundException e) {
        return BaseResponse.newInstance(Code.NO_FOUND, e.getMessage());
    }
}
