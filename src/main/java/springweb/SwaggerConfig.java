package springweb;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * SwaggerConfig.
 * URL: http://localhost:8080/swagger-ui/index.html
 *
 * @author Archon  2019/8/28
 * @since 0.1
 */
@Configuration
public class SwaggerConfig {

    /**
     * GroupedOpenApi
     *
     * @return OpenAPI 3.0
     */
    @Bean
    public GroupedOpenApi allApi() {
        return GroupedOpenApi.builder()
            .group("all-api")
            .pathsToMatch("/**")
            .build();
    }
}
