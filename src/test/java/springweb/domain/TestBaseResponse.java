package springweb.domain;

import org.junit.Test;
import springweb.domain.BaseResponse.Code;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Archon  2019/9/2
 * @since
 */
public class TestBaseResponse {

    @Test
    public void testCode() {
        assertThat(Code.OK.getCode()).isEqualTo(200);
        assertThat(Code.OK.name()).isEqualTo("OK");
    }

    @Test
    public void testBaseResponse() {
        BaseResponse br = BaseResponse.newInstance(Code.SERVER_ERROR, "server error");
        assertThat(br.getCode()).isEqualTo(500);
        assertThat(br.getData()).isEqualTo("server error");
    }
}
