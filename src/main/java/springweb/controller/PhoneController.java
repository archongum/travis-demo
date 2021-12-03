package springweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springweb.domain.Phone;
import springweb.service.PhoneService;


/**
 * @author Archon  12/3/2021
 * @since
 */
@RestController
public class PhoneController {

    private PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/getPhone/{name}")
    public Phone getPhone(@PathVariable String name) {
        // bad
//        Phone phone =  phoneService.getPhone(name);
//        phone.setType("B");
//        return phone;
        // good
        return phoneService.getPhone(name);
    };
}
