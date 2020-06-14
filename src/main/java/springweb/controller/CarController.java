package springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import springweb.domain.BaseResponse;
import springweb.exception.CarNotFoundException;
import springweb.service.CarService;
import springweb.util.BaseResponses;


/**
 * CarController.
 *
 * @author Archon  2019/8/28
 * @since 0.1
 */
@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{name}")
    private BaseResponse getCar(@PathVariable String name) throws CarNotFoundException {
        return BaseResponses.ok(carService.getCarDetails(name));
    }

    @GetMapping("/cars")
    private BaseResponse getAllCars() throws CarNotFoundException {
        return BaseResponses.ok(carService.getAllCars());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private BaseResponse carNotFoundHandler(CarNotFoundException e) {
        return BaseResponses.notFound(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private BaseResponse unknownException(Exception e) {
        return BaseResponses.internalServerError(e.getMessage());
    }
}
