package springweb.domain;

import org.junit.jupiter.api.Test;
import springweb.domain.BaseResponse.BaseStatus;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Archon  2019/9/2
 * @since 0.1
 */
class BaseResponseTest {

    @Test
    void equals() {
        BaseResponse b1 = new BaseResponse<>(BaseStatus.OK, new Car("name", "type"));
        BaseResponse b2 = new BaseResponse<>();
        b1.setStatus(BaseStatus.OK);
        b2.setData(new Car("name", "type"));
        assertThat(b1).isEqualTo(b2);
    }

    @Test
    void notEquals() {
        BaseResponse b1 = new BaseResponse<>(BaseStatus.OK, new Car("name", "type"));
        BaseResponse b2 = new BaseResponse<>(BaseStatus.NOT_FOUND, new Car("name", "type"));
        BaseResponse b3 = new BaseResponse<>(BaseStatus.OK, new Car("name2", "type"));
        BaseResponse b4 = new BaseResponse<>(BaseStatus.OK, "car");
        BaseResponse b5 = new BaseResponse<>(BaseStatus.OK, null);
        assertThat(b1).isNotEqualTo(b2)
                      .isNotEqualTo(b3)
                      .isNotEqualTo(b4)
                      .isNotEqualTo(b5)
                      .isNotEqualTo(null)
                      .isNotEqualTo("BaseResponse");
    }
}
