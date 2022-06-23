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

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @GetMapping("/base/profile")
    private BaseResponse getProfile() {
        return BaseResponses.ok(String.format("spring.application.name=%s, spring.datasource.username=%s, spring.datasource.password=%s", profile, username, password));
    }
}
