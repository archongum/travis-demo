package springweb;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import springweb.domain.Phone;
import springweb.mapper.PhoneMapper;
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

    @MockBean
    private PhoneMapper phoneMapper;

    @Before
    public void before() {
        BDDMockito.given(phoneMapper.getPhoneType("iPhone")).willReturn("Apple");
    }

    @Test
    public void getPhone_ShouldWork() {
        ResponseEntity<Phone> result = restTemplate.getForEntity("/getPhone/iPhone", Phone.class);

        Assertions.assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(result.getBody()).isEqualTo(new Phone("iPhone", "Apple"));
    }
}
