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
 * @since
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class TestIntegration {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetCar() {
        ResponseEntity<BaseResponse> response = restTemplate.getForEntity("/cars/prius", BaseResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getCode()).isEqualTo(200);
        HashMap map = (HashMap) response.getBody().getData();
        assertThat(map.get("name")).isEqualTo("prius");
        assertThat(map.get("type")).isEqualTo("hybrid");
    }
}
