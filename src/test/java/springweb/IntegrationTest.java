package springweb;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import springweb.domain.BaseResponse;
import springweb.domain.BaseResponse.BaseStatus;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


/**
 * @author Archon  2019/8/28
 * @since 0.1
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void cars_name_hasCar() {
        ResponseEntity<BaseResponse> response = restTemplate.getForEntity("/cars/prius", BaseResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getStatus()).isEqualTo(BaseStatus.OK);
        HashMap map = (HashMap) response.getBody().getData();
        assertThat(map.get("name")).isEqualTo("prius");
        assertThat(map.get("type")).isEqualTo("hybrid");
    }

    @Test
    void cars_name_noFound() {
        ResponseEntity<BaseResponse> response = restTemplate.getForEntity("/cars/a", BaseResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody().getStatus()).isEqualTo(BaseStatus.NOT_FOUND);
        assertThat(response.getBody().getData()).isEqualTo("Car Not Found");
    }

    @Test
    void cars() {
        ResponseEntity<BaseResponse> response = restTemplate.getForEntity("/cars", BaseResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getStatus()).isEqualTo(BaseStatus.OK);
    }
}
