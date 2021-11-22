package springweb.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


/**
 * Car.
 *
 * @author Archon  2019/8/28
 * @since 0.1
 */
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Car {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String type;

    private String remark;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(type, car.type);
    }
}
