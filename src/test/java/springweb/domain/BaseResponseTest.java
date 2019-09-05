package springweb.domain;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Archon  2019/9/2
 * @since 0.1
 */
public class BaseResponseTest {

    @Test
    public void baseResponse() {
        BaseResponse br = new BaseResponse<>(500, "server error");
        assertThat(br.getStatus()).isEqualTo(500);
        assertThat(br.getData()).isEqualTo("server error");
    }

    @Test
    public void toMap() {
        Map<String, Object> actually = new BaseResponse<>(500, "server error").toMap();
        Map<String, Object> expected = new LinkedHashMap<>(2);
        expected.put("status", 500);
        expected.put("data", "server error");
        assertThat(actually).isEqualTo(expected);
    }
}
