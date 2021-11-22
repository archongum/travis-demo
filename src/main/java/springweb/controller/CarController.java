package springweb.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
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
@AllArgsConstructor
@Slf4j
public class CarController {

    private final CarService carService;

    @GetMapping("/cars/{name}")
    private BaseResponse getCar(@PathVariable String name) throws CarNotFoundException {
        log.info("getCar, name: {}", name);
        // Return trace id in response.
        String traceId = TraceContext.traceId();
        return BaseResponses.ok(carService.getCarDetails(name) + ", trace id:" + traceId);
    }

    @GetMapping("/cars")
    private BaseResponse getAllCars() throws CarNotFoundException {
        log.info("getAllCars");
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
