package springweb.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Archon  2019/9/5
 * @since 0.1
 */
public class CarTest {

    @Test
    public void equals() {
        Car c1 = new Car("prius", "hybrid");
        Car c2 = new Car();
        c2.setName("prius");
        c2.setType("hybrid");
        assertThat(c1).isEqualTo(c2);
    }

    @Test
    public void notEquals() {
        Car c1 = new Car("prius", "hybrid");
        Car c2 = new Car("prius2", "hybrid");
        Car c3 = new Car("prius", "hybrid2");
        Car c4 = new Car("prius2", "hybrid2");
        assertThat(c1)
            .isNotEqualTo(c2)
            .isNotEqualTo(c3)
            .isNotEqualTo(c4)
            .isNotEqualTo("car")
            .isNotEqualTo(null);
    }
}
