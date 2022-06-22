package springweb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springweb.domain.BaseResponse;
import springweb.util.BaseResponses;


/**
 * @author Archon  2022/6/22
 * @since
 */
@RestController
public class BaseController {

    @Value("${spring.application.name}")
    private String profile;

    @Value("${spring.application.mykey}")
    private String mykey;

    @Value("${spring.datasource.password}")
    private String password;

    @GetMapping("/base/profile")
    private BaseResponse getProfile() {
        return BaseResponses.ok(String.format("spring.application.name=%s, \nspring.application.mykey=%s, \nspring.datasource.password=%s", profile, mykey, password));
    }
}
