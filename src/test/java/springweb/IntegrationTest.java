package springweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import springweb.domain.BaseResponse;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


/**
 * @author Archon  2019/8/28
 * @since 0.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void cars_name_hasCar() {
        ResponseEntity<BaseResponse> response = restTemplate.getForEntity("/cars/prius", BaseResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getStatus()).isEqualTo(200);
        HashMap map = (HashMap) response.getBody().getData();
        assertThat(map.get("name")).isEqualTo("prius");
        assertThat(map.get("type")).isEqualTo("hybrid");
    }

    @Test
    public void cars_name_noFound() {
        ResponseEntity<BaseResponse> response = restTemplate.getForEntity("/cars/a", BaseResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody().getStatus()).isEqualTo(404);
        assertThat(response.getBody().getData()).isEqualTo("Car Not Found");
    }

    @Test
    public void cars() {
        ResponseEntity<BaseResponse> response = restTemplate.getForEntity("/cars", BaseResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getStatus()).isEqualTo(200);
    }
}
