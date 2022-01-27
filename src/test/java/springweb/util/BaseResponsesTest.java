package springweb.util;

import org.junit.jupiter.api.Test;
import springweb.domain.BaseResponse;
import springweb.domain.BaseResponse.BaseStatus;
import springweb.domain.Car;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Archon  2019/9/5
 * @since
 */
class BaseResponsesTest {

    @Test
    void ok() {
        BaseResponse res = BaseResponses.ok(new Car("prius", "hybrid"));
        assertThat(res.getStatus()).isEqualTo(BaseStatus.OK);
        assertThat(res.getData().getClass()).isEqualTo(Car.class);
        Car car = (Car) res.getData();
        assertThat(car.getName()).isEqualTo("prius");
        assertThat(car.getType()).isEqualTo("hybrid");
    }

    @Test
    void noFound() {
        BaseResponse res = BaseResponses.notFound("Car Not Found");
        assertThat(res.getStatus()).isEqualTo(BaseStatus.NOT_FOUND);
        assertThat(res.getData()).isEqualTo("Car Not Found");
    }

    @Test
    void internalServerError() {
        BaseResponse res = BaseResponses.internalServerError("Unknown Exception");
        assertThat(res.getStatus()).isEqualTo(BaseStatus.INTERNAL_SERVER_ERROR);
        assertThat(res.getData()).isEqualTo("Unknown Exception");
    }
}
